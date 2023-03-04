package br.com.cwi.crescer.bePepe.mapper;

import br.com.cwi.crescer.bePepe.controller.response.CurtidaResponse;
import br.com.cwi.crescer.bePepe.domain.Curtida;

public class DetalheCurtidaMapper {
    public static CurtidaResponse toResponse(Curtida curtida) {
        return CurtidaResponse.builder()

                .id(curtida.getId())
                .usuarioId(curtida.getUsuario().getId())
                .postId(curtida.getPost().getId())
                .hasLike(curtida.getHasLike())
                .build();
    }
}
