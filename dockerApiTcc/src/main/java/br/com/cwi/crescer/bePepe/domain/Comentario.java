package br.com.cwi.crescer.bePepe.domain;

import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@EqualsAndHashCode(of= "id") @ToString(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Comentario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String comentarioTexto;

    private String comentarioImagem;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
