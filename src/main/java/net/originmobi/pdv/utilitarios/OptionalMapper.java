package net.originmobi.pdv.utilitarios;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
public final class OptionalMapper<T, R> {

  private final Optional<T> value;
  private Optional<R> result = Optional.empty();

  public OptionalMapper(T value) {
    super();
    this.value = Optional.ofNullable(value);
  }

  public <I> OptionalMapper<T, R> instance(Class<I> type, Function<I, ? extends R> mapper) {
    if (!result.isPresent()) {
      result = value.flatMap(DomainUtils.ifCast(type)).map(mapper);
    }
    return this;
  }

  public Optional<R> getResult() {
    return result;
  }
}
