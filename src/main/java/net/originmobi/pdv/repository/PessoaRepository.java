package net.originmobi.pdv.repository;

import net.originmobi.pdv.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

  Pessoa findByCpfcnpjContaining(String cpfcnpj);

  List<Pessoa> findByNomeContaining(String nome);

  Pessoa findByCodigoIn(Long codigo);

}
