package br.com.cwi.crescer.bePepe.controller.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ComentarioResponse {
    private Long id;
    private Long postId;
    private Long usuarioId;
    private String usuarioNome;
    private String comentarioTexto;
    private String comentarioImagem;
}
