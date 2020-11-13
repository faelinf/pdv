package net.originmobi.pdv.infra.exception;

import net.originmobi.pdv.infra.intercionalization.MessageResolver;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
@Component
public class ExceptionResolver {

  private final MessageResolver message;
  private final ErrorFactory errorFactory;
  private final HttpServletRequest request;

  public static final String MESSAGE_KEY = "erro";

  public ExceptionResolver(MessageResolver message, ErrorFactory errorFactory, HttpServletRequest request) {
    this.message = message;
    this.errorFactory = errorFactory;
    this.request = request;
  }

  public String resolve(Exception ex, RedirectAttributes attributes) {
    attributes.addFlashAttribute(MESSAGE_KEY, resolveMessage(ex));
    return redirectOrigin();
  }

  private String redirectOrigin() {
    final String origin = request.getHeader("origin");
    final String referer = request.getHeader("referer");
    final String request = StringUtils.difference(origin, referer);
    return String.format("redirect:%s", request);
  }

  private String resolveMessage(Exception ex) {
    return errorFactory.error(ex, message::resolve);
  }
}
