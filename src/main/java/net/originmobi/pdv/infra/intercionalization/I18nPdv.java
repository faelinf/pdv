package net.originmobi.pdv.infra.intercionalization;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
public enum I18nPdv implements I18nKey {

  // User
  USER_CURRENT_NOTFOUND("user.current.notFound"),
  USER_NOT_AUTHENTICATED("user.not.authenticated"),
  // System
  ERROR_INTERNAL("error.internal"),
  INVALID_OPERATION("invalid.operation"),
  ;

  private final String key;

  private I18nPdv(String key) {
    this.key = key;
  }

  @Override
  public String get() {
    return key;
  }
}
