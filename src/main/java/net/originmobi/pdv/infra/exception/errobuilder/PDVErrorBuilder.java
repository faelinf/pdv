package net.originmobi.pdv.infra.exception.errobuilder;

import net.originmobi.pdv.infra.exception.ErrorResponseBuilder;
import net.originmobi.pdv.infra.exception.PDVException;
import net.originmobi.pdv.infra.intercionalization.MessageBuilder;

/**
 * @author jonathas.assuncao on 13/11/2020
 * @project pdv
 */
public final class PDVErrorBuilder implements ErrorResponseBuilder<PDVException> {

  @Override
  public String build(PDVException exception, MessageBuilder messageBuilder) {
    return messageBuilder.message(exception.getMessageException());
  }

  @Override
  public boolean accept(Exception exception) {
    return PDVException.class.isInstance(exception);
  }

}
