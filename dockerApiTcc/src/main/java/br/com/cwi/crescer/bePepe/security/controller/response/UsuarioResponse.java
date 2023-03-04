package br.com.cwi.crescer.bePepe.security.controller.response;

import br.com.cwi.crescer.bePepe.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bePepe.controller.response.ListarPostResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String apelido;
    private String imagemPerfil;
    private List<ListarPostResponse> posts;
}
