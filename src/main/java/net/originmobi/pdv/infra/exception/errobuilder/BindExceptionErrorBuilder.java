package net.originmobi.pdv.infra.exception.errobuilder;

import net.originmobi.pdv.infra.exception.ErrorResponseBuilder;
import net.originmobi.pdv.infra.intercionalization.MessageBuilder;
import org.springframework.validation.BindException;

/**
 * @author jonathas.assuncao on 13/11/2020
 * @project pdv
 */
public class BindExceptionErrorBuilder implements ErrorResponseBuilder<BindException> {

  @Override
  public String build(BindException exception, MessageBuilder messageBuilder) {
    final String field = exception.getFieldError().getField();
    final String message = exception.getFieldError().getDefaultMessage();
    return String.format("%s: %s", field, message);
  }

  @Override
  public boolean accept(Exception exception) {
    return BindException.class.isInstance(exception);
  }
}
