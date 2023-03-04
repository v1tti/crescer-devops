package br.com.cwi.crescer.bePepe.security.service;

import br.com.cwi.crescer.bePepe.security.controller.request.EditarUsuarioRequest;
import br.com.cwi.crescer.bePepe.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.bePepe.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.repository.UsuarioRepository;
import br.com.cwi.crescer.bePepe.security.service.core.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.crescer.bePepe.security.mapper.UsuarioMapper.toResponse;

@Service
public class EditarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioService;

    @Transactional
    public UsuarioResponse editar(EditarUsuarioRequest request, Long id) {

        Usuario usuario = buscarUsuarioService.porId(id);
        usuario.setImagemPerfil(request.getImagemPerfil());
        usuario.setNome(request.getNome());
        usuario.setApelido(request.getApelido());
        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }
}
