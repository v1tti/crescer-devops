package br.com.cwi.crescer.bePepe.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostRequest {

    private String titulo;
    private String imagem;
    private String texto;

}
