package net.originmobi.pdv.domain.venda;

import net.originmobi.pdv.application.venda.VendaData;
import net.originmobi.pdv.domain.Pessoa;
import net.originmobi.pdv.domain.Usuario;
import net.originmobi.pdv.infra.exception.PDVException;
import net.originmobi.pdv.repository.VendaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class VendaUseCaseTest {

  @Mock
  private VendaUseCase vendaUseCase;
  @Mock
  private VendaRepository vendasRepository;
  @Mock
  private VendaData vendaData;
  @Mock
  private Pessoa pessoa;
  @Mock
  private Usuario usuario;
  @Mock
  private Venda venda;

  @BeforeEach
  void setup() throws Exception {
    vendaUseCase = new VendaUseCase(vendasRepository);
  }

  @Test
  void abrirCriar() throws Exception {
    when(vendaData.getCodigo()).thenReturn(Optional.empty());
    when(vendaData.getPessoa()).thenReturn(pessoa);
    when(vendaData.getUsuario()).thenReturn(usuario);

    vendaUseCase.abrir(vendaData);

    verify(vendasRepository, times(1)).save(any(Venda.class));
  }

  @Test
  void abrirAtualizar() throws Exception {
    when(vendaData.getCodigo()).thenReturn(Optional.of(1L));
    when(vendaData.getPessoa()).thenReturn(pessoa);
    when(vendaData.getUsuario()).thenReturn(usuario);
    when(vendasRepository.findById(1L)).thenReturn(Optional.of(venda));

    vendaUseCase.abrir(vendaData);

    verify(vendasRepository, times(1)).findById(1L);
    verify(vendasRepository, times(1)).save(any(Venda.class));
  }

  @Test
  void abrirAtualizar_CodigoInvalido() throws Exception {
    when(vendaData.getCodigo()).thenReturn(Optional.of(1L));
    when(vendaData.getPessoa()).thenReturn(pessoa);
    when(vendaData.getUsuario()).thenReturn(usuario);
    when(vendasRepository.findById(1L)).thenReturn(Optional.empty());

    assertThatThrownBy(() -> vendaUseCase.abrir(vendaData))
        .isInstanceOf(PDVException.class)
        .hasMessage("venda.notFound");

    verify(vendasRepository, times(1)).findById(1L);
    verify(vendasRepository, never()).save(any());
  }
}