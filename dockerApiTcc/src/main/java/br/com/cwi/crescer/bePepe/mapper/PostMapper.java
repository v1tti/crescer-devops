package br.com.cwi.crescer.bePepe.mapper;

import br.com.cwi.crescer.bePepe.controller.request.PostRequest;
import br.com.cwi.crescer.bePepe.controller.response.PostResponse;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.bePepe.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;

public class PostMapper {

    public static Post toEntity(PostRequest request) {
        Post entity = new Post();
        entity.setTitulo(request.getTitulo());
        entity.setImagem(request.getImagem());
        entity.setTexto(request.getTexto());

        return entity;
    }

    public static PostResponse toResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .titulo(post.getTitulo())
                .imagem(post.getImagem())
                .texto(post.getTexto())
                .publico(post.getPublico())
                .dataInclusao(post.getDataInclusao())
                .usuarioId(post.getUsuario().getId())
                .build();
    }
}
