package br.com.cwi.crescer.bePepe.service;

import br.com.cwi.crescer.bePepe.controller.request.CurtidaRequest;
import br.com.cwi.crescer.bePepe.controller.response.CurtidaResponse;
import br.com.cwi.crescer.bePepe.domain.Curtida;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.mapper.CurtidaMapper;
import br.com.cwi.crescer.bePepe.repository.CurtidaRepository;
import br.com.cwi.crescer.bePepe.repository.PostRepository;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.bePepe.service.core.BuscarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static br.com.cwi.crescer.bePepe.mapper.CurtidaMapper.toEntity;

@Service
public class CurtirPostService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BuscarPostService buscarPostService;

    @Transactional
    public CurtidaResponse curtirPost(Long idPost, CurtidaRequest request) {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        if(Objects.nonNull(curtidaRepository.findByUsuarioIdAndPostId(usuarioAutenticado.getId(),idPost))){
            Curtida curtida = curtidaRepository.findByUsuarioIdAndPostId(usuarioAutenticado.getId(),idPost);
            curtida.setHasLike(!curtida.getHasLike());
            return CurtidaMapper.toResponse(curtida);
        }
        Post post = buscarPostService.porId(idPost);
        Curtida curtida = toEntity(request);
        curtida.setUsuario(usuarioAutenticado);
        curtida.setHasLike(request.isHasLike());
        post.adicionarCurtida(curtida);

        postRepository.save(post);

        curtidaRepository.save(curtida);

        return CurtidaMapper.toResponse(curtida);
    }

}
