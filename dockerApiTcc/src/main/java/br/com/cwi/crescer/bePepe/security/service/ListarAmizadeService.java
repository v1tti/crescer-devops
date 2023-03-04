package br.com.cwi.crescer.bePepe.security.service;

import br.com.cwi.crescer.bePepe.domain.Situacao;
import br.com.cwi.crescer.bePepe.repository.AmizadeRepository;
import br.com.cwi.crescer.bePepe.security.controller.response.AmizadesResponse;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.mapper.AmizadesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarAmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public List<AmizadesResponse> listar() {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        return amizadeRepository
                .findBySituacaoIs(Situacao.ACEITA)
                .stream().map(AmizadesMapper::toResponse).collect(Collectors.toList());
    }

    public List<AmizadesResponse> listarSolicitada() {

        return amizadeRepository
                .findBySituacaoIs(Situacao.PENDENTE)
                .stream().map(AmizadesMapper::toResponse).collect(Collectors.toList());
    }
}
