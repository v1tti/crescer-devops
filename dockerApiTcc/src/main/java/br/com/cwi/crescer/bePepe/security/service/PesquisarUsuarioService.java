package br.com.cwi.crescer.bePepe.security.service;

import br.com.cwi.crescer.bePepe.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bePepe.security.mapper.UsuarioMapper;
import br.com.cwi.crescer.bePepe.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PesquisarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public Page<UsuarioResponse> listarUsuariosPaginado(String searchTerm, Pageable pageable) {


        return usuarioRepository.findFirstByNomeContainsOrEmailContainsAllIgnoreCase(searchTerm,searchTerm, pageable)
                .map(UsuarioMapper::toResponse);


    }
}
