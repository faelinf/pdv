package net.originmobi.pdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.originmobi.pdv.domain.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
	
	public Telefone findByCodigoIn(long codigo);

}
