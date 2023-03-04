package br.com.cwi.crescer.bePepe.mapper;

import br.com.cwi.crescer.bePepe.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bePepe.controller.response.CurtidaResponse;
import br.com.cwi.crescer.bePepe.controller.response.ListarPostResponse;
import br.com.cwi.crescer.bePepe.domain.Comentario;
import br.com.cwi.crescer.bePepe.domain.Curtida;
import br.com.cwi.crescer.bePepe.domain.Post;

import java.util.List;
import java.util.stream.Collectors;

public class ListarPostMapper {
    public static ListarPostResponse toResponse(Post entity) {
        return ListarPostResponse.builder()
                .id(entity.getId())
                .texto(entity.getTexto())
                .dataInclusao(entity.getDataInclusao())
                .imagem(entity.getImagem())
                .publico(entity.getPublico())
                .titulo(entity.getTitulo())
                .usuarioId(entity.getUsuario().getId())
                .usuarioNome(entity.getUsuario().getNome())
                .comentarios(comentarios(entity.getComentarios()))
                .curtidas(curtidas(entity.getCurtidas()))
                .build();
    }

    private static List<ComentarioResponse> comentarios(List<Comentario> comentarios) {
        return comentarios.stream()
                .map(DetalheComentarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    private static List<CurtidaResponse> curtidas(List<Curtida> curtidas) {
        return curtidas.stream()
                .map(DetalheCurtidaMapper::toResponse)
                .collect(Collectors.toList());
    }
}
