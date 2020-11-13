package net.originmobi.pdv.infra.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionAdvice {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ExceptionResolver exceptionResolver;

  @ExceptionHandler(RuntimeException.class)
  public String runtimeException(RuntimeException ex, RedirectAttributes attributes) {
    logException(ex);
    return exceptionResolver.resolve(ex, attributes);
  }

  @ExceptionHandler(Exception.class)
  public String exception(Exception ex, RedirectAttributes attributes) {
    logException(ex);
    return exceptionResolver.resolve(ex, attributes);
  }

  private void logException(Throwable ex) {
    log.error("Error: {}", ex.getMessage(), ex);
  }
}
