package br.com.cwi.crescer.bePepe.security.service;

import br.com.cwi.crescer.bePepe.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.repository.UsuarioRepository;
import br.com.cwi.crescer.bePepe.security.service.core.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.crescer.bePepe.security.mapper.UsuarioMapper.toResponse;

@Service
public class BuscarUsuarioDetalhadoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioService;
    public UsuarioResponse buscar(Long id) {

        Usuario usuario = buscarUsuarioService.porId(id);
        return toResponse(usuario);
    }
}
