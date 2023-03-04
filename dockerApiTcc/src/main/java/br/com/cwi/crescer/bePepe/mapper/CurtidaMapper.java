package br.com.cwi.crescer.bePepe.mapper;

import br.com.cwi.crescer.bePepe.controller.request.CurtidaRequest;
import br.com.cwi.crescer.bePepe.controller.response.CurtidaResponse;
import br.com.cwi.crescer.bePepe.domain.Curtida;

public class CurtidaMapper {

    public static Curtida toEntity(CurtidaRequest request) {
        Curtida entity = new Curtida();
        entity.setHasLike(request.isHasLike());
        return entity;
    }

    public static CurtidaResponse toResponse(Curtida curtida) {

        return CurtidaResponse.builder()
                .id(curtida.getId())
                .postId(curtida.getPost().getId())
                .usuarioId(curtida.getUsuario().getId())
                .hasLike(curtida.getHasLike())
                .build();
    }
}
