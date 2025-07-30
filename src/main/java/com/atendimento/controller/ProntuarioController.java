package com.atendimento.controller;

import com.atendimento.dto.ProntuarioRequestDTO;
import com.atendimento.model.Prontuario;
import com.atendimento.service.ProntuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prontuarios")
public class ProntuarioController {
    @Autowired
    private ProntuarioService prontuarioService;

    @PostMapping("/preencher")
    public ResponseEntity<Prontuario> preencherProntuario(@RequestBody ProntuarioRequestDTO prontuarioRequestDTO) {
        Prontuario prontuario = prontuarioService.preencher(prontuarioRequestDTO.getIdSessao(), prontuarioRequestDTO.getTexto(), prontuarioRequestDTO.getRestrito());
        return ResponseEntity.ok(prontuario);
    }

    @GetMapping("/listar/{idSessao}")
    public ResponseEntity<List<Prontuario>> preencherProntuario(@RequestParam String idSessao) {
        List<Prontuario> prontuario = prontuarioService.listar(idSessao);
        return ResponseEntity.ok(prontuario);
    }

}
