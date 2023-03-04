package br.com.cwi.crescer.bePepe.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioRequest {
    private String comentarioTexto;
    private String comentarioImagem;
}
