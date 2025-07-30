package com.atendimento.service;

import com.atendimento.exceptionsApp.AtendimentoPsicologicoException;
import com.atendimento.model.Agenda;
import com.atendimento.model.SlotAgenda;
import com.atendimento.repository.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    public Agenda getOrCreateByPsicologo(String idPsicologo) {
        return agendaRepository.findByIdPsicologo(idPsicologo)
                .orElseGet(() -> {
                    Agenda agenda = new Agenda();
                    agenda.setIdPsicologo(idPsicologo);
                    agendaRepository.save(agenda);
                    return agenda;
                });
    }

    public SlotAgenda addSlot(String idPsicologo, LocalDate data, LocalTime hora) {
        Agenda agenda = getOrCreateByPsicologo(idPsicologo);
        SlotAgenda slot = new SlotAgenda();
        slot.setData(data);
        slot.setHora(hora);

        agenda.getSlots().add(slot);
        agendaRepository.save(agenda);
        return slot;
    }

    public List<SlotAgenda> listSlotsLivres(String idPsicologo) {
        Agenda agenda = getOrCreateByPsicologo(idPsicologo);
        return agenda.getSlots().stream()
                .filter(s -> s.getIdSessao() == null)
                .toList();
    }

    public SlotAgenda getSlotOrThrow(String idPsicologo, String slotId) {
        Agenda agenda = agendaRepository.findByIdPsicologo(idPsicologo)
                .orElseThrow(() -> new AtendimentoPsicologicoException("Agenda não encontrada para o psicólogo", HttpStatus.NOT_FOUND.value()));
        return agenda.getSlots().stream()
                .filter(s -> s.getId().equals(slotId))
                .findFirst()
                .orElseThrow(() -> new AtendimentoPsicologicoException("Slot não encontrado", HttpStatus.NOT_FOUND.value()));
    }

    public void vincularSessaoAoSlot(String idPsicologo, String slotId, String idSessao) {
        Agenda agenda = agendaRepository.findByIdPsicologo(idPsicologo)
                .orElseThrow(() -> new AtendimentoPsicologicoException("Agenda não encontrada para o psicólogo", HttpStatus.NOT_FOUND.value()));

        SlotAgenda slot = agenda.getSlots().stream()
                .filter(s -> s.getId().equals(slotId))
                .findFirst()
                .orElseThrow(() -> new AtendimentoPsicologicoException("Slot não encontrado", HttpStatus.NOT_FOUND.value()));

        if (slot.getIdSessao() != null) {
            throw new AtendimentoPsicologicoException("Slot já está ocupado", HttpStatus.BAD_REQUEST.value());
        }

        slot.setIdSessao(idSessao);
        agendaRepository.save(agenda);
    }
}