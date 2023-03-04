package br.com.cwi.crescer.bePepe.repository;

import br.com.cwi.crescer.bePepe.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
