package com.atendimento.controller;

import com.atendimento.dto.LoginRequestDTO;
import com.atendimento.model.Usuario;
import com.atendimento.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO req) {
        return ResponseEntity.ok(usuarioService.login(req.getEmail(), req.getSenha()));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuario));
    }
}
