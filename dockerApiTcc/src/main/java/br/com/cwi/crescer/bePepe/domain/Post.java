package br.com.cwi.crescer.bePepe.domain;

import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@EqualsAndHashCode(of= "id") @ToString(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String titulo;

    private String imagem;

    private String texto;


    private LocalDate dataInclusao;

    private Boolean publico;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "post")
    private List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comentario> comentarios = new ArrayList<>();

    public void adicionarComentario(Comentario comentario) {
        this.getComentarios().add(comentario);
        comentario.setPost(this);
    }
    public void adicionarCurtida(Curtida curtida) {
        this.getCurtidas().add(curtida);
        curtida.setPost(this);
    }

}
