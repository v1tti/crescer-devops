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
public class Amizade {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "amigo_id")
    private Usuario amigo;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    public void adicionarNovaSolicitacao(Usuario usuarioDesejado, Usuario usuarioAutenticado) {
        this.setUsuario(usuarioAutenticado);
        this.setAmigo(usuarioDesejado);
    }
}
