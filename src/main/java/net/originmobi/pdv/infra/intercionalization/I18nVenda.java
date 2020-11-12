package net.originmobi.pdv.infra.intercionalization;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
public enum I18nVenda implements I18nKey {
  VENDA_NOTNULL("venda.notNull"),
  VENDA_NOTFOUND("venda.notFound"),
  ;

  private final String key;

  private I18nVenda(String key) {
    this.key = key;
  }

  @Override
  public String get() {
    return key;
  }
}
