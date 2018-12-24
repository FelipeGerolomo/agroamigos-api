package br.agroamigos.repository;

import br.agroamigos.model.Cotacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Integer> {
    Page<Cotacao> findByIndicador(Integer indicadorId, Pageable pageable);
}
