package br.com.cwi.crescer.bePepe.controller.response;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PostResponse {
    private Long id;
    private String titulo;
    private String imagem;
    private String texto;
    private LocalDate dataInclusao;
    private Boolean publico;
    private Long usuarioId;
}
