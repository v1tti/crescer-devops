package br.com.cwi.crescer.bePepe.service.core;

import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.repository.PostRepository;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarPostService {

    @Autowired
    private PostRepository postRepository;

    public Post porId(Long id) {
        return postRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "post não encontrado"));
    }
}
