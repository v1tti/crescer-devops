package br.com.cwi.crescer.bePepe.factories;

import br.com.cwi.crescer.bePepe.domain.Post;

import java.time.LocalDate;
import java.util.ArrayList;

public class PostFactory {

    public static Post.PostBuilder getBuilder() {
        return Post.builder()
                .id(SimpleFactory.getRandomLong())
                .texto("String")
                .publico(true)
                .imagem("ImagemUrl")
                .dataInclusao(LocalDate.of(2022,3,1))
                .usuario(UsuarioFactory.get())
                .titulo("Titulo post")
                .usuario(UsuarioFactory.get())
                .comentarios(new ArrayList<>())
                .curtidas(new ArrayList<>());

    }
}
