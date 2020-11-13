package net.originmobi.pdv.infra.exception;

import net.originmobi.pdv.infra.intercionalization.I18nKey;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
public class PDVException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final transient List<Object> params;

  public PDVException(String key, List<Object> params) {
    super(key);
    this.params = Objects.nonNull(params) ? params : Collections.emptyList();
  }

  public PDVException(I18nKey key, List<Object> params, Throwable throwable) {
    super(key.get(), throwable);
    this.params = Objects.nonNull(params) ? params : Collections.emptyList();
  }

  public PDVException(I18nKey key, List<Object> params) {
    this(key.get(), params);
  }

  public PDVException(I18nKey key) {
    this(key, Collections.emptyList());
  }

  public PDVException(MessageException messageParams) {
    this(messageParams.getKey(), messageParams.getParams());
  }

  public MessageException getMessageException() {
    return new MessageException(getMessage(), params);
  }

  public List<Object> getParams() {
    return Collections.unmodifiableList(params);
  }

  public static Supplier<PDVException> supplier(I18nKey key, Object... args) {
    return () -> PDVException.valueOf(key, args);
  }

  public static PDVException valueOf(I18nKey key, Object... args) {
    return new PDVException(key, params(args));
  }

  public static PDVException valueOf(Throwable throwable, I18nKey key, Object... args) {
    return new PDVException(key, params(args), throwable);
  }

  public static PDVException valueOf(I18nKey key) {
    return new PDVException(key);
  }

  protected static List<Object> params(Object... args) {
    return Arrays.stream(args).filter(Objects::nonNull).collect(Collectors.toList());
  }
}
