package br.com.cwi.crescer.bePepe.mapper;

import br.com.cwi.crescer.bePepe.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bePepe.domain.Comentario;
import br.com.cwi.crescer.bePepe.factories.ComentarioFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ComentarioMapperTest {

    @Test
    @DisplayName("Deve retornar comentario completo")
    void deveRetornarCompleto() {
        Comentario comentario = ComentarioFactory.getComentario();

        ComentarioResponse response = ComentarioMapper.toResponse(comentario);

        assertEquals(comentario.getId(), response.getId());
        assertEquals(comentario.getComentarioImagem(), response.getComentarioImagem());
    }


}
