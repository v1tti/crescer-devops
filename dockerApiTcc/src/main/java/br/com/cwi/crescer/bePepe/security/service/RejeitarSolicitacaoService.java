package br.com.cwi.crescer.bePepe.security.service;

import br.com.cwi.crescer.bePepe.domain.Amizade;
import br.com.cwi.crescer.bePepe.domain.Situacao;
import br.com.cwi.crescer.bePepe.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RejeitarSolicitacaoService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Transactional
    public void rejeitar(Long id) {

        Amizade amizade = amizadeRepository.findById(id).get();
        amizade.setSituacao(Situacao.REJEITADA);

        amizadeRepository.save(amizade);
    }
}
