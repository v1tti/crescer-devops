package br.com.cwi.crescer.bePepe.security.service;

import br.com.cwi.crescer.bePepe.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.mapper.UsuarioMapper;
import br.com.cwi.crescer.bePepe.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarUsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<UsuarioResponse> listar() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper::toResponse).collect(Collectors.toList());
    }
}
