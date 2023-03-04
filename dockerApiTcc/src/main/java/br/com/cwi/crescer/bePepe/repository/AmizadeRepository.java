package br.com.cwi.crescer.bePepe.repository;

import br.com.cwi.crescer.bePepe.domain.Amizade;
import br.com.cwi.crescer.bePepe.domain.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmizadeRepository extends JpaRepository<Amizade, Long> {


    List<Amizade> findBySituacaoIs(Situacao situacao);
}
