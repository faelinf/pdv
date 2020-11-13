package net.originmobi.pdv.infra.intercionalization;

import net.originmobi.pdv.infra.exception.MessageException;

/**
 * @author jonathas.assuncao on 13/11/2020
 * @project pdv
 */
@FunctionalInterface
public interface MessageBuilder {

  String message(String key, Object... args);

  default String message(I18nKey key, Object... args) {
    return message(key.get(), args);
  }

  default String message(MessageException message) {
    return message(message.getKey(), message.getArrayParams());
  }

}