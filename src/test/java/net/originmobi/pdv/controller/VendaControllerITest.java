package net.originmobi.pdv.controller;

import net.originmobi.pdv.application.venda.SystemResolver;
import net.originmobi.pdv.domain.Pessoa;
import net.originmobi.pdv.domain.venda.Venda;
import net.originmobi.pdv.enumerado.VendaSituacao;
import net.originmobi.pdv.infra.intercionalization.I18nVenda;
import net.originmobi.pdv.infra.intercionalization.MessageResolver;
import net.originmobi.pdv.repository.PessoaRepository;
import net.originmobi.pdv.repository.VendaRepository;
import net.originmobi.pdv.settings.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.ResultActions;

import static net.originmobi.pdv.domain.venda.VendaTesteDataBuilder.createVenda;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
class VendaControllerITest extends IntegrationTest {

  @Autowired
  private PessoaRepository pessoaRepository;
  @Autowired
  private VendaRepository vendaRepository;
  @Autowired
  private SystemResolver systemResolver;
  @Autowired
  private MessageResolver message;

  private Pessoa pessoa;

  @BeforeEach
  public void setUp() throws Exception {
    pessoa = pessoaRepository.findAll().get(0);
  }

  @Test
  @WithMockUser("gerente")
  void abrirVenda_Criar() throws Exception {
    final ResultActions actions = mockMvc().perform(post("/venda")
        .param("pessoa", String.valueOf(pessoa.getCodigo()))
        .param("observacao", "obs")
    ).andExpect(status().isFound());

    final Long codigo = extractCodigoOf(actions);

    actions
        .andExpect(flash().attribute("mensagem", message.resolve(I18nVenda.VENDA_SAVE)))
        .andExpect(redirectedUrl(String.format("/venda/%s", codigo)));

    final Venda result = vendaRepository.getOne(codigo);

    assertThat(result.getCodigo()).isEqualTo(codigo);
    assertThat(result.getPessoa()).isEqualTo(pessoa);
    assertThat(result.getObservacao()).isEqualTo("obs");
  }

  @Test
  @WithMockUser("gerente")
  void abrirVenda_Alterar() throws Exception {
    final Venda venda = save(createVenda()
        .pessoa(pessoa)
        .usuario(systemResolver.getUsuarioAtual())
        .situacao(VendaSituacao.ABERTA)
        .build());

    final ResultActions actions = mockMvc().perform(post("/venda")
        .param("codigo", String.valueOf(venda.getCodigo()))
        .param("pessoa", String.valueOf(pessoa.getCodigo()))
        .param("observacao", "obs2")
    )
        .andExpect(status().isFound());

    final Long codigo = extractCodigoOf(actions);

    actions
        .andExpect(flash().attribute("mensagem", message.resolve(I18nVenda.VENDA_SAVE)))
        .andExpect(redirectedUrl(String.format("/venda/%s", codigo)));

    final Venda result = vendaRepository.getOne(codigo);

    assertThat(result.getCodigo()).isEqualTo(codigo);
    assertThat(result.getPessoa()).isEqualTo(pessoa);
    assertThat(result.getObservacao()).isEqualTo("obs2");
  }
}