package net.originmobi.pdv.domain.venda;

import net.originmobi.pdv.application.venda.VendaData;
import net.originmobi.pdv.domain.PagamentoTipo;
import net.originmobi.pdv.domain.Pessoa;
import net.originmobi.pdv.domain.Produto;
import net.originmobi.pdv.domain.Usuario;
import net.originmobi.pdv.enumerado.VendaSituacao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jonathas.assuncao on 13/11/2020
 * @project pdv
 */
public class VendaTesteDataBuilder {

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

  public VendaTesteDataBuilder codigo(Long codigo) {
    this.codigo = codigo;
    return this;
  }

  public VendaTesteDataBuilder observacao(String observacao) {
    this.observacao = observacao;
    return this;
  }

  public VendaTesteDataBuilder valorProdutos(Double valorProdutos) {
    this.valorProdutos = valorProdutos;
    return this;
  }

  public VendaTesteDataBuilder valorDesconto(Double valorDesconto) {
    this.valorDesconto = valorDesconto;
    return this;
  }

  public VendaTesteDataBuilder valorAcrescimo(Double valorAcrescimo) {
    this.valorAcrescimo = valorAcrescimo;
    return this;
  }

  public VendaTesteDataBuilder valorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
    return this;
  }

  public VendaTesteDataBuilder situacao(VendaSituacao situacao) {
    this.situacao = situacao;
    return this;
  }

  public VendaTesteDataBuilder dataCadastro(Timestamp dataCadastro) {
    this.dataCadastro = dataCadastro;
    return this;
  }

  public VendaTesteDataBuilder dataFinalizado(Timestamp dataFinalizado) {
    this.dataFinalizado = dataFinalizado;
    return this;
  }

  public VendaTesteDataBuilder dataCancelado(Timestamp dataCancelado) {
    this.dataCancelado = dataCancelado;
    return this;
  }

  public VendaTesteDataBuilder pessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
    return this;
  }

  public VendaTesteDataBuilder usuario(Usuario usuario) {
    this.usuario = usuario;
    return this;
  }

  public VendaTesteDataBuilder pagamentoTipo(PagamentoTipo pagamentoTipo) {
    this.pagamentotipo = pagamentoTipo;
    return this;
  }

  public VendaTesteDataBuilder produto(List<Produto> produto) {
    this.produto = produto;
    return this;
  }

  public VendaData data() {
    VendaData data = new VendaData();
    data.setCodigo(codigo);
    data.setObservacao(observacao);
    data.setValorProdutos(valorProdutos);
    data.setValorDesconto(valorDesconto);
    data.setValorAcrescimo(valorAcrescimo);
    data.setValorTotal(valorTotal);
    data.setSituacao(situacao);
    data.setDataCadastro(dataCadastro);
    data.setDataFinalizado(dataFinalizado);
    data.setDataCancelado(dataCancelado);
    data.setPessoa(pessoa);
    data.setUsuario(usuario);
    data.setPagamentotipo(pagamentotipo);
    data.setProduto(produto);
    return data;
  }

  public Venda build() {
    return new Venda(data());
  }

  public static VendaTesteDataBuilder createVenda() {
    return new VendaTesteDataBuilder();
  }
}
