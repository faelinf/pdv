package net.originmobi.pdv.repository.notafiscal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.originmobi.pdv.domain.NotaFiscalItem;

public interface NotaFiscalItemRepository extends JpaRepository<NotaFiscalItem, Long> {

	@Query(value = "select nfi.cod_prod, prod.descricao, prod.ncm, nfii.cst, nfi.cfop, prod.unidade, nfi.qtd qtd, prod.valor_venda, "
			+ "nfi.vl_total, total_produto, nfii.v_bc bc_icms, nfii.v_icms vl_icms, "
			+ "nfii.p_icms aliq_icms, nfi.codigo, nfi.nota_fiscal_codigo from nota_fiscal_item nfi,"
			+ "produto prod, nota_fiscal_item_imposto nfii where nfi.cod_prod = prod.codigo "
			+ "and nfii.codigo = nfi.imposto_codigo and nfi.nota_fiscal_codigo = ?1", nativeQuery = true)
	List<Object> findByNotaFiscalCodigoEquals(Long codigo);
}
