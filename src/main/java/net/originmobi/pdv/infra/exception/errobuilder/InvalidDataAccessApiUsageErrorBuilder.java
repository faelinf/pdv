package net.originmobi.pdv.infra.exception.errobuilder;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import net.originmobi.pdv.infra.exception.ErrorResponseBuilder;
import net.originmobi.pdv.infra.intercionalization.I18nPdv;
import net.originmobi.pdv.infra.intercionalization.MessageBuilder;
import org.springframework.dao.InvalidDataAccessApiUsageException;

/**
 * @author jonathas.assuncao on 13/11/2020
 * @project pdv
 */
public final class InvalidDataAccessApiUsageErrorBuilder implements ErrorResponseBuilder<InvalidDataAccessApiUsageException> {

  @Override
  public String build(InvalidDataAccessApiUsageException exception, MessageBuilder messageBuilder) {
    if (exception.getCause() instanceof IllegalArgumentException) {
      IllegalArgumentException illegalArgumentException = (IllegalArgumentException) exception.getCause();
      if (illegalArgumentException.getCause() instanceof MismatchedInputException) {
        return messageBuilder.message(I18nPdv.ERROR_INTERNAL);
      }
    }
    return messageBuilder.message(I18nPdv.INVALID_OPERATION);
  }

  @Override
  public boolean accept(Exception exception) {
    return InvalidDataAccessApiUsageException.class.isInstance(exception);
  }

}
