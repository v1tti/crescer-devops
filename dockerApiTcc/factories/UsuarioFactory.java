package br.com.cwi.crescer.bePepe.factories;

import br.com.cwi.crescer.bePepe.security.domain.Usuario;

import java.time.LocalDate;

public class UsuarioFactory {

    public static Usuario get() {
        Usuario usuario = new Usuario();
        usuario.setId(SimpleFactory.getRandomLong());
        usuario.setNome("Usuário de teste");
        usuario.setEmail("teste@cwi.com.br");
        usuario.setApelido("Apelido");
        usuario.setImagemPerfil("imagem Perfil Url");
        usuario.setDataNascimento(LocalDate.of(2022,03,1));
        return usuario;
    }
}
