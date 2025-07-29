package com.atendimento.controller;

import com.atendimento.model.Psicologo;
import com.atendimento.service.PsicologoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/psicologo")
public class PsicologoController {
    @Autowired
    private final PsicologoService psicologoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> login(@RequestBody Psicologo psicologo) {
        return ResponseEntity.ok(psicologoService.cadastrarPsicologo(psicologo));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Psicologo> login(@RequestParam String idUsuario) {
        return ResponseEntity.ok(psicologoService.buscarPsicologo(idUsuario));
    }
}
