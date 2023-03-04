package br.com.cwi.crescer.bePepe.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class EditarUsuarioRequest {

    @NotBlank
    private String nome;



    private String apelido;


    private String imagemPerfil;
}
