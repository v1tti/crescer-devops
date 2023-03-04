package br.com.cwi.crescer.bePepe.repository;

import br.com.cwi.crescer.bePepe.domain.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {


    Curtida findByUsuarioIdAndPostId(Long idUser, Long idPost);
}
