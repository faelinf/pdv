package net.originmobi.pdv.service.notafiscal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.originmobi.pdv.domain.NotaFiscalFinalidade;
import net.originmobi.pdv.repository.notafiscal.NotaFiscalFinalidadeRepository;

@Service
public class NotaFiscalFinalidadeServer {

	@Autowired
	private NotaFiscalFinalidadeRepository repository;

	public List<NotaFiscalFinalidade> lista() {
		return repository.findAll();
	}

}
