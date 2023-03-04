package br.com.cwi.crescer.bePepe.mapper;

import br.com.cwi.crescer.bePepe.controller.request.ComentarioRequest;
import br.com.cwi.crescer.bePepe.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bePepe.domain.Comentario;

public class ComentarioMapper {

    public static Comentario toEntity(ComentarioRequest request) {
        Comentario entity = new Comentario();

        entity.setComentarioTexto(request.getComentarioTexto());
        entity.setComentarioImagem(request.getComentarioImagem());

        return entity;
    }

    public static ComentarioResponse toResponse(Comentario comentario) {

        return ComentarioResponse.builder()
                .id(comentario.getId())
                .comentarioImagem(comentario.getComentarioImagem())
                .comentarioTexto(comentario.getComentarioTexto())
                .postId(comentario.getPost().getId())
                .usuarioId(comentario.getUsuario().getId())
                .build();
    }
}
