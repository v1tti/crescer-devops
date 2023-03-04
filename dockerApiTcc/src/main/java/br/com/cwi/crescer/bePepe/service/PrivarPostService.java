package br.com.cwi.crescer.bePepe.service;

import br.com.cwi.crescer.bePepe.controller.request.PrivarPostRequest;
import br.com.cwi.crescer.bePepe.controller.response.PostResponse;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.mapper.PostMapper;
import br.com.cwi.crescer.bePepe.repository.PostRepository;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.bePepe.service.core.BuscarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrivarPostService {


    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BuscarPostService buscarPostService;
    
    @Transactional
    public PostResponse privarPost(Long idPost, PrivarPostRequest request) {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();
        Post post = buscarPostService.porId(idPost);

        post.setPublico(!post.getPublico());

        postRepository.save(post);

        return PostMapper.toResponse(post);
    }

}
