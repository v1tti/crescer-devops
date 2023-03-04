package br.com.cwi.crescer.bePepe.controller.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CurtidaResponse {
    private Long id;
    private Long postId;
    private Long usuarioId;
    private Boolean hasLike;

}
