package br.com.cwi.crescer.bePepe.factories;

import br.com.cwi.crescer.bePepe.domain.Curtida;

import java.util.Random;

public class CurtidaFactory {

    public static Curtida criarCurtida() {
        return getBuilder().build();
    }

    public static Curtida.CurtidaBuilder getBuilder() {
        return Curtida.builder()
                .usuario(UsuarioFactory.get())
                .id(getRandomLong())
                .hasLike(true)
                .post(PostFactory.getBuilder().build());
    }

    private static Long getRandomLong() {
        return new Random().nextLong();
    }
}
