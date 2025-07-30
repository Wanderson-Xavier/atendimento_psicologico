package com.atendimento.controller;

import com.atendimento.dto.CreateSlotRequest;
import com.atendimento.model.SlotAgenda;
import com.atendimento.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/psicologos/{idPsicologo}/agendas")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @PostMapping("/slots")
    public ResponseEntity<SlotAgenda> createSlot(
            @PathVariable String idPsicologo,
            @RequestBody CreateSlotRequest req
    ) {
        SlotAgenda slot = agendaService.addSlot(idPsicologo, req.data(), req.hora());
        return ResponseEntity.ok(slot);
    }

    @GetMapping("/slots/livres")
    public ResponseEntity<List<SlotAgenda>> slotsLivres(@PathVariable String idPsicologo) {
        return ResponseEntity.ok(agendaService.listSlotsLivres(idPsicologo));
    }
}
