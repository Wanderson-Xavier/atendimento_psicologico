package com.atendimento.controller;

import com.atendimento.dto.ConcluirSessaoRequestDTO;
import com.atendimento.dto.MarcarSessaoRequestDTO;
import com.atendimento.model.Sessao;
import com.atendimento.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessoes")
public class SessaoController {
    @Autowired
    private final SessaoService sessaoService;

    @PostMapping
    public ResponseEntity<Sessao> marcar(@RequestBody MarcarSessaoRequestDTO marcarSessaoRequestDTO) {
        return ResponseEntity.ok(
                sessaoService.marcar(marcarSessaoRequestDTO.getIdPaciente(), marcarSessaoRequestDTO.getIdPsicologo(), marcarSessaoRequestDTO.getIdSlot())
        );
    }

    @PostMapping("/{idSessao}/concluir")
    public ResponseEntity<Sessao> concluir(
            @PathVariable String idSessao,
            @RequestBody ConcluirSessaoRequestDTO concluirSessaoRequestDTO
    ) {
        return ResponseEntity.ok(sessaoService.concluir(idSessao, concluirSessaoRequestDTO.getIdPsicologo()));
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<Sessao>> porPaciente(@PathVariable String idPaciente) {
        return ResponseEntity.ok(sessaoService.porPaciente(idPaciente));
    }

    @GetMapping("/psicologo/{idPsicologo}")
    public ResponseEntity<List<Sessao>> porPsicologo(@PathVariable String idPsicologo) {
        return ResponseEntity.ok(sessaoService.porPsicologo(idPsicologo));
    }
}
