package com.atendimento.service;

import com.atendimento.enums.StatusSessaoEnum;
import com.atendimento.exceptionsApp.AtendimentoPsicologicoException;
import com.atendimento.model.Avaliacao;
import com.atendimento.model.Sessao;
import com.atendimento.repository.AvaliacaoRepository;
import com.atendimento.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    @Autowired
    private SessaoRepository sessaoRepository;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao avaliar(String idPaciente, String idSessao, int nota, String comentario) {
        Sessao sessao = sessaoRepository.findById(idSessao)
                .orElseThrow(() -> new AtendimentoPsicologicoException("Sessão não encontrada", HttpStatus.BAD_REQUEST.value()));

        if (!sessao.getIdPaciente().equals(idPaciente)) {
            throw new AtendimentoPsicologicoException("Paciente não pertence à sessão", HttpStatus.BAD_REQUEST.value());
        }
        if (sessao.getStatus() != StatusSessaoEnum.CONCLUIDA) {
            throw new AtendimentoPsicologicoException("Sessão ainda não concluída", HttpStatus.BAD_REQUEST.value());
        }

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdPaciente(idPaciente);
        avaliacao.setIdSessao(idSessao);
        avaliacao.setIdPsicologo(sessao.getIdPsicologo());
        avaliacao.setNota(nota);
        avaliacao.setComentario(comentario);

        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> porPsicologo(String idPsicologo) {
        return avaliacaoRepository.findByIdPsicologo(idPsicologo);
    }
}
