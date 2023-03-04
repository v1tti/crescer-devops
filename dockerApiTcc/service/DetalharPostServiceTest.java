package br.com.cwi.crescer.bePepe.service;

import br.com.cwi.crescer.bePepe.controller.response.ListarPostResponse;
import br.com.cwi.crescer.bePepe.domain.Post;
import br.com.cwi.crescer.bePepe.factories.PostFactory;
import br.com.cwi.crescer.bePepe.factories.UsuarioFactory;
import br.com.cwi.crescer.bePepe.repository.PostRepository;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.service.UsuarioAutenticadoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DetalharPostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @InjectMocks
    private DetalharPostService detalharPostService;

    private final Long ID_USUARIO_AUTENTICADO = 1L;

    @Test
    void DeveListarPostagemDeAmigos() {

        Pageable pageable = PageRequest.of(0, 5);
        Usuario usuarioMockado = UsuarioFactory.get();

        List<Post> postagens = List.of(
                PostFactory.getBuilder().id(1L).build(),
                PostFactory.getBuilder().id(2L).build(),
                PostFactory.getBuilder().id(3L).build()
        );

        Page<Post> postagensPaginadas = new PageImpl<>(postagens);

        when(usuarioAutenticadoService.get()).thenReturn(usuarioMockado);
        when(postRepository.listarPosts(usuarioMockado.getId(), pageable)).thenReturn(postagensPaginadas);

        Page<ListarPostResponse> response = detalharPostService.listar(pageable);

        verify(postRepository).listarPosts(usuarioMockado.getId(), pageable);

        assertEquals(postagensPaginadas.getSize(), response.getSize());
        assertEquals(postagensPaginadas.getTotalElements(), response.getTotalElements());
        assertEquals(postagensPaginadas.getTotalPages(), response.getTotalPages());

    }

}