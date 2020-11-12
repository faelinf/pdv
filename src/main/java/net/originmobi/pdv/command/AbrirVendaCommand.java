package net.originmobi.pdv.command;

import net.originmobi.pdv.domain.Pessoa;

import java.util.Optional;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
public class AbrirVendaCommand {

  public Long codigo;

  public String observacao;

  public Optional<String> getObservacao() {
    return Optional.ofNullable(observacao);
  }

  public Optional<Long> getCodigo() {
    return Optional.ofNullable(codigo);
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public Pessoa pessoa;
}
