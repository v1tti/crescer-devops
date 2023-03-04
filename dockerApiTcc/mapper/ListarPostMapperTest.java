package br.com.cwi.crescer.bePepe.mapper;

import br.com.cwi.crescer.bePepe.controller.response.ListarPostResponse;
import br.com.cwi.crescer.bePepe.domain.Comentario;
import br.com.cwi.crescer.bePepe.domain.Curtida;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.factories.ComentarioFactory;
import br.com.cwi.crescer.bePepe.factories.CurtidaFactory;
import br.com.cwi.crescer.bePepe.factories.UsuarioFactory;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ListarPostMapperTest {

    @Test
    public void testToResponse() {
        Post post = new Post();
        post.setId(1L);
        post.setTitulo("Teste");
        post.setImagem("imagem.jpg");
        post.setTexto("Conteúdo do post");
        post.setPublico(true);
        post.setDataInclusao(LocalDate.of(2022,3,1));
        Usuario usuario = UsuarioFactory.get();
        post.setUsuario(usuario);
        List<Comentario> comentarios = new ArrayList<>();
        Comentario comentario = ComentarioFactory.getComentario();

        Usuario usuarioComentario = new Usuario();
        usuarioComentario.setId(2L);
        usuarioComentario.setNome("Usuário Comentário");
        comentario.setUsuario(usuarioComentario);
        comentarios.add(comentario);
        post.setComentarios(comentarios);
        List<Curtida> curtidas = new ArrayList<>();
        Curtida curtida = CurtidaFactory.criarCurtida();

        Usuario usuarioCurtida = usuario;
        curtida.setUsuario(usuarioCurtida);
        curtidas.add(curtida);
        post.setCurtidas(curtidas);

        ListarPostResponse response = ListarPostMapper.toResponse(post);

        assertEquals(1L, response.getId());
        assertEquals("Teste", response.getTitulo());
        assertEquals("imagem.jpg", response.getImagem());
        assertEquals("Conteúdo do post", response.getTexto());
        assertNotNull(response.getDataInclusao());
        assertEquals(usuario.getId(), response.getUsuarioId());
        assertEquals(usuario.getNome(), response.getUsuarioNome());
        assertEquals(1, response.getComentarios().size());
        assertEquals("texto comentario", response.getComentarios().get(0).getComentarioTexto());
        assertEquals(2L, response.getComentarios().get(0).getUsuarioId());
        assertEquals("Usuário Comentário", response.getComentarios().get(0).getUsuarioNome());
        assertEquals(1, response.getCurtidas().size());
        assertEquals(usuario.getId(), response.getCurtidas().get(0).getUsuarioId());

    }
}
