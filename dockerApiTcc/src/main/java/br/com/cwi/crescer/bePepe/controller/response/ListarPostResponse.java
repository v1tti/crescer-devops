package br.com.cwi.crescer.bePepe.controller.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ListarPostResponse {
    private Long id;
    private String titulo;
    private String imagem;
    private String texto;
    private LocalDate dataInclusao;
    private Boolean publico;
    private Long usuarioId;
    private String usuarioNome;
    private List<ComentarioResponse> comentarios;
    private List<CurtidaResponse> curtidas;
}
