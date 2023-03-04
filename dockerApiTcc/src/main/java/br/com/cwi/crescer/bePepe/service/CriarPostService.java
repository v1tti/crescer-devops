package br.com.cwi.crescer.bePepe.service;

import br.com.cwi.crescer.bePepe.controller.request.PostRequest;
import br.com.cwi.crescer.bePepe.controller.response.PostResponse;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.mapper.PostMapper;
import br.com.cwi.crescer.bePepe.repository.PostRepository;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.bePepe.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.crescer.bePepe.mapper.PostMapper.toResponse;

@Service
public class CriarPostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private NowService nowService;

    @Transactional
    public PostResponse incluir(PostRequest request) {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();
        Post post = PostMapper.toEntity(request);

        post.setTitulo(request.getTitulo());
        post.setTexto(request.getTexto());
        post.setPublico(true);
        post.setImagem(request.getImagem());
        post.setDataInclusao(nowService.getDate());
        post.setUsuario(usuarioAutenticado);

        usuarioAutenticado.adicionarPost(post);
        postRepository.save(post);

        return toResponse(post);
    }
}
