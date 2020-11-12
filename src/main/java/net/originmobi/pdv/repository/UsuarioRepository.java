package net.originmobi.pdv.repository;

import net.originmobi.pdv.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  public Usuario findByPessoaCodigoEquals(Long codigo);

  public Usuario findByUserEquals(String user);

  public Usuario findByUserContaining(String usuario);

  Optional<Usuario> findByCodigoIn(Long codigo);

}
