package com.atendimento.service;


import com.atendimento.model.Usuario;
import com.atendimento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public String login(String email, String senha) {
        Optional<Usuario> usuario = repository.findByEmail(email);
        if (usuario.isEmpty()) {
            System.out.println("Usuário não encontrado.");
            return "Usuário não encontrado.";
        } else {
            if (usuario.get().getSenha() != null && usuario.get().getSenha().equals(senha)) {
                System.out.println("Autenticação bem-sucedida! Bem-vindo, " + email);
                return usuario.get().getId();
            } else {
                System.out.println("Senha incorreta.");
                return "Senha incorreta.";
            }
        }
    }

    public String cadastrarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioExistente = repository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isEmpty()) {
            repository.save(usuario);
            return "Usuario cadastrado com sucesso";
        } else {
            return "Usuário já cadastrado";
        }
    }
}