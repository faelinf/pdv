package net.originmobi.pdv.domain.venda;

import net.originmobi.pdv.application.venda.VendaData;
import net.originmobi.pdv.infra.exception.PDVException;
import net.originmobi.pdv.infra.intercionalization.I18nVenda;
import net.originmobi.pdv.repository.VendaRepository;
import net.originmobi.pdv.utilitarios.Checker;
import org.springframework.stereotype.Service;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
@Service
public class VendaUseCase {

  private final VendaRepository vendasRepository;

  public VendaUseCase(VendaRepository vendasRepository) {
    this.vendasRepository = vendasRepository;
  }

  public Venda abrir(VendaData data) {
    Checker.notNull(data, I18nVenda.VENDA_NOTNULL);
    return data.getCodigo().map(c -> atualizarVenda(data)).orElse(criarVenda(data));
  }

  private Venda criarVenda(VendaData data) {
//    final Venda venda = new Venda(data);
//    venda.abrir();
//    return vendasRepository.save(venda);
    return null;
  }

  private Venda atualizarVenda(VendaData data) {
    final Venda venda = data.getCodigo().flatMap(vendasRepository::findById)
        .orElseThrow(() -> PDVException.valueOf(I18nVenda.VENDA_NOTFOUND));
//    venda.update(data);
    return vendasRepository.save(venda);
  }
}
