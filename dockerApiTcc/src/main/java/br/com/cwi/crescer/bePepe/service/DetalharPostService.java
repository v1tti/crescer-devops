package br.com.cwi.crescer.bePepe.service;

import br.com.cwi.crescer.bePepe.controller.response.ListarPostResponse;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.mapper.ListarPostMapper;
import br.com.cwi.crescer.bePepe.repository.PostRepository;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DetalharPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;


    public Page<ListarPostResponse> listar(Pageable pageable) {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        Page<Post> posts = postRepository.listarPosts(usuarioAutenticado.getId(),pageable);

        Page<ListarPostResponse> response = posts.map(post -> ListarPostMapper.toResponse(post));

        return response;
    }
}
