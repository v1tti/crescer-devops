package br.com.cwi.crescer.bePepe.mapper;

import br.com.cwi.crescer.bePepe.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bePepe.domain.Comentario;

public class DetalheComentarioMapper {
    public static ComentarioResponse toResponse(Comentario comentario) {
        return ComentarioResponse.builder()
                .comentarioTexto(comentario.getComentarioTexto())
                .id(comentario.getId())
                .usuarioId(comentario.getUsuario().getId())
                .usuarioNome(comentario.getUsuario().getNome())
                .postId(comentario.getPost().getId())
                .comentarioImagem(comentario.getComentarioImagem())
                .build();
    }
}
