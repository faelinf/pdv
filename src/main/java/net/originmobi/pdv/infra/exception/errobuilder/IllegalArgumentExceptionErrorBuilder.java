package net.originmobi.pdv.infra.exception.errobuilder;

import net.originmobi.pdv.infra.exception.ErrorResponseBuilder;
import net.originmobi.pdv.infra.intercionalization.MessageBuilder;

/**
 * @author jonathas.assuncao on 13/11/2020
 * @project pdv
 */
public final class IllegalArgumentExceptionErrorBuilder implements ErrorResponseBuilder<IllegalArgumentException> {

  @Override
  public String build(IllegalArgumentException exception, MessageBuilder messageBuilder) {
    return messageBuilder.message(exception.getMessage());
  }

  @Override
  public boolean accept(Exception exception) {
    return IllegalArgumentException.class.isInstance(exception);
  }
}
