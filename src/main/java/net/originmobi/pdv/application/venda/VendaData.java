package net.originmobi.pdv.application.venda;

import net.originmobi.pdv.domain.PagamentoTipo;
import net.originmobi.pdv.domain.Pessoa;
import net.originmobi.pdv.domain.Produto;
import net.originmobi.pdv.domain.Usuario;
import net.originmobi.pdv.enumerado.VendaSituacao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
public class VendaData {

  private Long codigo;
  private String observacao;
  private Double valorProdutos;
  private Double valorDesconto;
  private Double valorAcrescimo;
  private Double valorTotal;
  private VendaSituacao situacao;
  private Timestamp dataCadastro;
  private Timestamp dataFinalizado;
  private Timestamp dataCancelado;
  private Pessoa pessoa;
  private Usuario usuario;
  private PagamentoTipo pagamentotipo;
  private List<Produto> produto = new ArrayList<Produto>();

  public Optional<Long> getCodigo() {
    return Optional.ofNullable(codigo);
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public Optional<String> getObservacao() {
    return Optional.ofNullable(observacao);
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public Double getValorProdutos() {
    return valorProdutos;
  }

  public void setValorProdutos(Double valorProdutos) {
    this.valorProdutos = valorProdutos;
  }

  public Double getValorDesconto() {
    return valorDesconto;
  }

  public void setValorDesconto(Double valorDesconto) {
    this.valorDesconto = valorDesconto;
  }

  public Double getValorAcrescimo() {
    return valorAcrescimo;
  }

  public void setValorAcrescimo(Double valorAcrescimo) {
    this.valorAcrescimo = valorAcrescimo;
  }

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public VendaSituacao getSituacao() {
    return situacao;
  }

  public void setSituacao(VendaSituacao situacao) {
    this.situacao = situacao;
  }

  public Timestamp getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(Timestamp dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public Timestamp getDataFinalizado() {
    return dataFinalizado;
  }

  public void setDataFinalizado(Timestamp dataFinalizado) {
    this.dataFinalizado = dataFinalizado;
  }

  public Timestamp getDataCancelado() {
    return dataCancelado;
  }

  public void setDataCancelado(Timestamp dataCancelado) {
    this.dataCancelado = dataCancelado;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public PagamentoTipo getPagamentotipo() {
    return pagamentotipo;
  }

  public void setPagamentotipo(PagamentoTipo pagamentotipo) {
    this.pagamentotipo = pagamentotipo;
  }

  public List<Produto> getProduto() {
    return produto;
  }

  public void setProduto(List<Produto> produto) {
    this.produto = produto;
  }
}
