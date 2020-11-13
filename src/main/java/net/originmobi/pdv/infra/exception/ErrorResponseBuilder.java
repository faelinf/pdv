package net.originmobi.pdv.infra.exception;

import net.originmobi.pdv.infra.intercionalization.MessageBuilder;

/**
 * @author jonathas.assuncao on 13/11/2020
 * @project pdv
 */
public interface ErrorResponseBuilder<T extends Exception> {

  String build(T exception, MessageBuilder messageBuilder);

  boolean accept(Exception exception);

  default String call(Exception exception, MessageBuilder messageBuilder) {
    T value = resolve(exception);
    return build(value, messageBuilder);
  }

  @SuppressWarnings("unchecked")
  default T resolve(Exception exception) {
    return (T) exception;
  }
}
