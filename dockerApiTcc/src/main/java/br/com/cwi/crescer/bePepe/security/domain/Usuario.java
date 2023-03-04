package br.com.cwi.crescer.bePepe.security.domain;

import br.com.cwi.crescer.bePepe.domain.Amizade;
import br.com.cwi.crescer.bePepe.domain.Comentario;
import br.com.cwi.crescer.bePepe.domain.Curtida;
import br.com.cwi.crescer.bePepe.domain.Post;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    private String apelido;

    private String imagemPerfil;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    private boolean ativo;

    @OneToMany(mappedBy = "usuario")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Amizade> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "amigo")
    private List<Amizade> amigos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

       public void adicionarPost(Post post) {
        this.getPosts().add(post);
        post.setUsuario(this);
    }
}
