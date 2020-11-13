package net.originmobi.pdv.application.venda;

import net.originmobi.pdv.command.AbrirVendaCommand;
import net.originmobi.pdv.repository.PessoaRepository;
import org.springframework.stereotype.Component;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
@Component
public class VendaResolver {

  private final PessoaRepository pessoaRepository;
  private final SystemResolver systemResolver;

  public VendaResolver(SystemResolver systemResolver, PessoaRepository pessoaRepository) {
    this.systemResolver = systemResolver;
    this.pessoaRepository = pessoaRepository;
  }

  public VendaData resolve(AbrirVendaCommand command) {
    VendaData data = new VendaData();
    command.getCodigo().ifPresent(data::setCodigo);
    data.setPessoa(pessoaRepository.getOne(command.getPessoa()));
    data.setUsuario(systemResolver.getUsuarioAtual());
    command.getObservacao().ifPresent(data::setObservacao);
    return data;
  }
}
