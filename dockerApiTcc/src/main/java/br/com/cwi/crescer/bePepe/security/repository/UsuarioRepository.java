package br.com.cwi.crescer.bePepe.security.repository;

import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Page<Usuario> findFirstByNomeContainsOrEmailContainsAllIgnoreCase(String nome, String email, Pageable pageable);
}
