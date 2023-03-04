package br.com.cwi.crescer.bePepe.security.service;

import br.com.cwi.crescer.bePepe.domain.Amizade;
import br.com.cwi.crescer.bePepe.domain.Situacao;
import br.com.cwi.crescer.bePepe.repository.AmizadeRepository;
import br.com.cwi.crescer.bePepe.security.domain.Usuario;
import br.com.cwi.crescer.bePepe.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnviarSolicitacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Transactional
    public void enviar(Long id) {

        Usuario usuarioDesejado = usuarioRepository.findById(id).get();

        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        Amizade amizade = new Amizade();

        amizade.adicionarNovaSolicitacao(usuarioDesejado, usuarioAutenticado);
        amizade.setSituacao(Situacao.PENDENTE);

        amizadeRepository.save(amizade);
    }
}
