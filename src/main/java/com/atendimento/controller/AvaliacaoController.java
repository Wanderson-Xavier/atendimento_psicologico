package com.atendimento.controller;

import com.atendimento.dto.AvaliacaoRequestDTO;
import com.atendimento.model.Avaliacao;
import com.atendimento.service.AvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<Avaliacao> avaliar(@RequestBody AvaliacaoRequestDTO avaliacaoRequestDTO) {
        return ResponseEntity.ok(
                avaliacaoService.avaliar(avaliacaoRequestDTO.getIdPaciente(), avaliacaoRequestDTO.getIdSessao(),
                        avaliacaoRequestDTO.getNota(), avaliacaoRequestDTO.getComentario())
        );
    }

    @GetMapping("/psicologo/{idPsicologo}")
    public ResponseEntity<List<Avaliacao>> porPsicologo(@PathVariable String idPsicologo) {
        return ResponseEntity.ok(avaliacaoService.porPsicologo(idPsicologo));
    }
}
