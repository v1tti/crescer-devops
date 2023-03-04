package br.com.cwi.crescer.bePepe.service.core;

import br.com.cwi.crescer.bePepe.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class BuscarPostServiceTest {

    @InjectMocks
    private BuscarPostService tested;

    @Mock
    private PostRepository repository;

    @Test
    @DisplayName("Deve retornar erro quando não encontrar post")
    void deveRetornarErro() {

        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> tested.porId(1L));

        assertEquals("post não encontrado", exception.getReason());
    }
}
