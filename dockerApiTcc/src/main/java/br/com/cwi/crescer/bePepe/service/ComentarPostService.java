package br.com.cwi.crescer.bePepe.service;

import br.com.cwi.crescer.bePepe.controller.request.ComentarioRequest;
import br.com.cwi.crescer.bePepe.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bePepe.domain.Comentario;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.repository.ComentarioRepository;
import br.com.cwi.crescer.bePepe.repository.PostRepository;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.bePepe.service.core.BuscarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.crescer.bePepe.mapper.ComentarioMapper.toEntity;
import static br.com.cwi.crescer.bePepe.mapper.ComentarioMapper.toResponse;

@Service
public class ComentarPostService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BuscarPostService buscarPostService;

    @Transactional
    public ComentarioResponse comentarPost(Long idPost, ComentarioRequest request) {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();
        Post post = buscarPostService.porId(idPost);
        Comentario comentario = toEntity(request);
        comentario.setUsuario(usuarioAutenticado);
        post.adicionarComentario(comentario);

        postRepository.save(post);

        comentarioRepository.save(comentario);

        return toResponse(comentario);
    }
}
