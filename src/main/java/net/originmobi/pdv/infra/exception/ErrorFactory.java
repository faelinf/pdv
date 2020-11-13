package net.originmobi.pdv.infra.exception;

import net.originmobi.pdv.infra.exception.errobuilder.BindExceptionErrorBuilder;
import net.originmobi.pdv.infra.exception.errobuilder.IllegalArgumentExceptionErrorBuilder;
import net.originmobi.pdv.infra.exception.errobuilder.InvalidDataAccessApiUsageErrorBuilder;
import net.originmobi.pdv.infra.exception.errobuilder.PDVErrorBuilder;
import net.originmobi.pdv.infra.intercionalization.I18nPdv;
import net.originmobi.pdv.infra.intercionalization.MessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author jonathas.assuncao on 13/11/2020
 * @project pdv
 */
@Component
public class ErrorFactory {

  private static final String EXCEPTION_NOT_MAPPED = "Exception not mapped: {}";

  private final Logger log = LoggerFactory.getLogger(this.getClass());
  private final Set<ErrorResponseBuilder<?>> builders = new LinkedHashSet<>();

  ErrorFactory() {
    builders.add(new InvalidDataAccessApiUsageErrorBuilder());
    builders.add(new IllegalArgumentExceptionErrorBuilder());
    builders.add(new BindExceptionErrorBuilder());
    builders.add(new PDVErrorBuilder());
  }

  public String error(Exception ex, MessageBuilder builder) {
    return resolveError(ex, builder).orElse(internalError(ex, builder));
  }

  private Optional<String> resolveError(Exception ex, MessageBuilder messageBuilder) {
    final Optional<ErrorResponseBuilder<?>> builder = builders.stream().filter(b -> b.accept(ex)).findFirst();
    return builder.map(b -> b.call(ex, messageBuilder));
  }

  private String internalError(Exception ex, MessageBuilder builder) {
    log.warn(EXCEPTION_NOT_MAPPED, ex.getMessage(), ex);
    return builder.message(I18nPdv.ERROR_INTERNAL);
  }
}
