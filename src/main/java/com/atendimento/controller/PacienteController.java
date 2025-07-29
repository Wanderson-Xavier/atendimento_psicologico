package com.atendimento.controller;

import com.atendimento.dto.LoginRequestDTO;
import com.atendimento.model.Paciente;
import com.atendimento.model.Usuario;
import com.atendimento.service.PacienteService;
import com.atendimento.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private final PacienteService pacienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> login(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.cadastrarPaciente(paciente));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Paciente> login(@RequestParam String idUsuario) {
        return ResponseEntity.ok(pacienteService.buscarPaciente(idUsuario));
    }
}
