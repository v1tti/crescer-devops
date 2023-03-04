package br.com.cwi.crescer.bePepe.mapper;

import br.com.cwi.crescer.bePepe.controller.request.PostRequest;
import br.com.cwi.crescer.bePepe.controller.response.PostResponse;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.factories.UsuarioFactory;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PostMapperTest {
    @Test
    public void testToEntity() {
        PostRequest request = new PostRequest();
        request.setTitulo("Teste");
        request.setImagem("imagem.jpg");
        request.setTexto("Conteúdo do post");

        Post entity = PostMapper.toEntity(request);

        assertEquals("Teste", entity.getTitulo());
        assertEquals("imagem.jpg", entity.getImagem());
        assertEquals("Conteúdo do post", entity.getTexto());
    }

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
        usuario.setId(1L);
        post.setUsuario(usuario);

        PostResponse response = PostMapper.toResponse(post);

        assertEquals(1L, response.getId());
        assertEquals("Teste", response.getTitulo());
        assertEquals("imagem.jpg", response.getImagem());
        assertEquals("Conteúdo do post", response.getTexto());
        assertTrue(response.getPublico());
        assertNotNull(response.getDataInclusao());
        assertEquals(1L, response.getUsuarioId());
    }
}
