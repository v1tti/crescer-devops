package br.com.cwi.crescer.bePepe.factories;

import br.com.cwi.crescer.bePepe.domain.Comentario;

public class ComentarioFactory {

    public static Comentario.ComentarioBuilder getBuilder() {
        return Comentario.builder()
                .id(SimpleFactory.getRandomLong())
                .comentarioImagem("imagemComentarioUrl")
                .comentarioTexto("texto comentario")
                .usuario(UsuarioFactory.get())
                .post(PostFactory.getBuilder().build());
    }
    public static Comentario getComentario() {
        return getBuilder()
                .build();
    }
}
