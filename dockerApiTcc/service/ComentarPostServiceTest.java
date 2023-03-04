package br.com.cwi.crescer.bePepe.service;


import br.com.cwi.crescer.bePepe.controller.request.ComentarioRequest;
import br.com.cwi.crescer.bePepe.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.repository.ComentarioRepository;
import br.com.cwi.crescer.bePepe.repository.PostRepository;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.bePepe.service.core.BuscarPostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComentarPostServiceTest {

    @Mock
    private ComentarioRepository comentarioRepository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private PostRepository postRepository;

    @Mock
    private BuscarPostService buscarPostService;

    @InjectMocks
    private ComentarPostService comentarPostService;

    private Usuario usuarioAutenticado;
    private Post post;

    @BeforeEach
    public void setUp() {
        usuarioAutenticado = new Usuario();
        usuarioAutenticado.setId(1L);
        usuarioAutenticado.setNome("Usuário Autenticado");
        usuarioAutenticado.setEmail("usuario@cwi.com.br");
        usuarioAutenticado.setApelido("Apelido");
        usuarioAutenticado.setImagemPerfil("imagem Perfil Url");
        usuarioAutenticado.setDataNascimento(LocalDate.of(2000, 1, 1));

        post = new Post();
        post.setId(1L);
        post.setTitulo("Teste");
        post.setImagem("imagem.jpg");
        post.setTexto("Conteúdo do post");
        post.setPublico(true);
        post.setDataInclusao(LocalDate.of(2022, 3, 1));
        post.setUsuario(usuarioAutenticado);
    }

    @Test
    public void testComentarPost() {
        ComentarioRequest request = new ComentarioRequest();
        request.setComentarioTexto("Comentário teste");

        when(usuarioAutenticadoService.get()).thenReturn(usuarioAutenticado);
        when(buscarPostService.porId(post.getId())).thenReturn(post);

        ComentarioResponse response = comentarPostService.comentarPost(post.getId(), request);

        assertNotNull(response);

        assertEquals(request.getComentarioTexto(), response.getComentarioTexto());
        assertEquals(usuarioAutenticado.getId(), response.getUsuarioId());

    }


    }

