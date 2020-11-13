package net.originmobi.pdv.application.venda;

import net.originmobi.pdv.domain.Usuario;
import net.originmobi.pdv.infra.exception.PDVException;
import net.originmobi.pdv.infra.intercionalization.I18nPdv;
import net.originmobi.pdv.repository.UsuarioRepository;
import net.originmobi.pdv.security.UsuarioSistema;
import net.originmobi.pdv.utilitarios.OptionalMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
@Service
public class SystemResolver {

  private final UsuarioRepository usuarioRepository;

  public SystemResolver(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public Usuario getUsuarioAtual() {
    return usuario().orElseThrow(usuarioAtualNaoEncontrado());
  }

  public Optional<Usuario> usuario() {
    return usuarioRepository.findByUser(username());
  }

  private String username() {
    final Object autenticacao = autenticado().getPrincipal();
    return new OptionalMapper<Object, String>(autenticacao)
        .instance(UsuarioSistema.class, UsuarioSistema::getUsername)
        .instance(User.class, User::getUsername)
        .getResult().orElseThrow(naoAutenticado());
  }

  private Authentication autenticado() {
    return autenticacao().orElseThrow(naoAutenticado());
  }

  public static Optional<Authentication> autenticacao() {
    return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
  }

  private Supplier<PDVException> usuarioAtualNaoEncontrado() {
    return () -> PDVException.valueOf(I18nPdv.USER_CURRENT_NOTFOUND);
  }

  private Supplier<PDVException> naoAutenticado() {
    return () -> PDVException.valueOf(I18nPdv.USER_NOT_AUTHENTICATED);
  }
}
