package net.originmobi.pdv.infra.intercionalization;

import org.springframework.stereotype.Component;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
@Component
public class MessageResolver {

  public String resolve(I18nKey key) {
    return key.get();
  }
}
