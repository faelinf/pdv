package net.originmobi.pdv.command;

import java.util.Optional;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
public class AbrirVendaCommand {

  public Long codigo;

  public Long pessoa;

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

  public Long getPessoa() {
    return pessoa;
  }

  public void setPessoa(Long pessoa) {
    this.pessoa = pessoa;
  }


}
