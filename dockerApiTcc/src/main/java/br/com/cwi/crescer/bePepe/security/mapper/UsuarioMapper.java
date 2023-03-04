package br.com.cwi.crescer.bePepe.security.mapper;

import br.com.cwi.crescer.bePepe.controller.response.ListarPostResponse;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.mapper.ListarPostMapper;
import br.com.cwi.crescer.bePepe.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.bePepe.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setEmail(request.getEmail());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setApelido(request.getApelido());
        entity.setImagemPerfil(request.getImagemPerfil());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setEmail(entity.getEmail());
        response.setApelido(entity.getApelido());
        response.setImagemPerfil(entity.getImagemPerfil());
        response.setDataNascimento(entity.getDataNascimento());
        response.setPosts(posts(entity.getPosts()));
        return response;
    }
    private static List<ListarPostResponse> posts(List<Post> posts) {
        return posts.stream()
                .map(ListarPostMapper::toResponse)
                .collect(Collectors.toList());
    }
}
