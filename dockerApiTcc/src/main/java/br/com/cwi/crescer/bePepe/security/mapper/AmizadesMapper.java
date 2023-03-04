package br.com.cwi.crescer.bePepe.security.mapper;

import br.com.cwi.crescer.bePepe.domain.Amizade;
import br.com.cwi.crescer.bePepe.security.controller.response.AmizadesResponse;
import br.com.cwi.crescer.bePepe.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;

public class AmizadesMapper {

    public static AmizadesResponse toResponse(Amizade entity) {
        AmizadesResponse response = new AmizadesResponse();
        response.setAmigo(entity.getAmigo().getNome());
        response.setUsuario(entity.getUsuario().getNome());
        response.setUsuarioId(entity.getUsuario().getId());
        response.setAmigoId(entity.getAmigo().getId());
        response.setSituacao(entity.getSituacao());
        response.setId(entity.getId());

        return response;
    }
}
