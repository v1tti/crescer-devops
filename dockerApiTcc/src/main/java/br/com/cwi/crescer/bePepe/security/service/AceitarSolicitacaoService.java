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
public class AceitarSolicitacaoService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Transactional
    public void aceitar(Long id) {

        Amizade amizade = amizadeRepository.findById(id).get();
        amizade.setSituacao(Situacao.ACEITA);

        amizadeRepository.save(amizade);
    }
}
