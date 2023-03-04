package br.com.cwi.crescer.bePepe.security.controller.response;

import br.com.cwi.crescer.bePepe.domain.Situacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmizadesResponse {

    private Long id;
    private Situacao situacao;
    private String amigo;
    private String usuario;
    private Long usuarioId;
    private Long amigoId;

}
