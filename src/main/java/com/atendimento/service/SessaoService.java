package com.atendimento.service;

import com.atendimento.enums.StatusSessaoEnum;
import com.atendimento.exceptionsApp.AtendimentoPsicologicoException;
import com.atendimento.model.Sessao;
import com.atendimento.model.SlotAgenda;
import com.atendimento.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;
    @Autowired
    private AgendaService agendaService;

    public Sessao marcar(String idPaciente, String idPsicologo, String slotId) {
        SlotAgenda slot = agendaService.getSlotOrThrow(idPsicologo, slotId);
        if (slot.getIdSessao() != null) {
            throw new AtendimentoPsicologicoException("Slot já foi ocupado.", HttpStatus.BAD_REQUEST.value());
        }

        LocalDateTime dataHora = LocalDateTime.of(slot.getData(), slot.getHora());

        Sessao sessao = new Sessao();
        sessao.setIdPaciente(idPaciente);
        sessao.setIdPsicologo(idPsicologo);
        sessao.setDataHora(dataHora);
        sessao.setIdSlot(slotId);
        sessao.setStatus(StatusSessaoEnum.AGENDADA);

        sessao = sessaoRepository.save(sessao);

        agendaService.vincularSessaoAoSlot(idPsicologo, slotId, sessao.getId());
        return sessao;
    }

    public List<Sessao> porPaciente(String idPaciente) {
        return sessaoRepository.findByIdPaciente(idPaciente);
    }

    public List<Sessao> porPsicologo(String idPsicologo) {
        return sessaoRepository.findByIdPsicologo(idPsicologo);
    }

    public Sessao concluir(String idSessao, String idPsicologo) {
        Sessao s = sessaoRepository.findById(idSessao)
                .orElseThrow(() -> new AtendimentoPsicologicoException("Sessão não encontrada", HttpStatus.BAD_REQUEST.value()));

        if (!s.getIdPsicologo().equals(idPsicologo)) {
            throw new AtendimentoPsicologicoException("Sessão não pertence a este psicólogo", HttpStatus.BAD_REQUEST.value());
        }

        s.setStatus(StatusSessaoEnum.CONCLUIDA);
        return sessaoRepository.save(s);
    }
}
