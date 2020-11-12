package net.originmobi.pdv.infra.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
@Component
public class ExceptionResolver {

  public static final String MESSAGE_KEY = "message";
  public static final String ACTION = "redirect:";
  public static final String VIEW = "/error";

  public String resolve(Exception ex, RedirectAttributes attributes) {
    attributes.addFlashAttribute(MESSAGE_KEY, resolveMessage(ex));
    return String.format("%s%s", ACTION, VIEW);
  }

  private String resolveMessage(Exception ex) {
    return ex.getMessage();
  }
}
