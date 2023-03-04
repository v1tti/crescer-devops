package br.com.cwi.crescer.bePepe.repository;

import br.com.cwi.crescer.bePepe.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.publico = true OR p.usuario.id = :id "+
            "OR (p.usuario.id IN " +
            "(SELECT a.amigo.id from Amizade a WHERE a.usuario.id = :id " +
            "AND a.situacao = 'ACEITA') " +
            "OR (p.usuario.id IN " +
            "(SELECT a.usuario.id from Amizade a WHERE a.amigo.id = :id " +
            "AND a.situacao = 'ACEITA')))"
    )
    Page<Post> listarPosts(@Param("id")Long id, Pageable pageable);

    Page<Post> findAllByPublicoOrUsuarioIdIs(boolean b,Long id, Pageable pageable);
}
