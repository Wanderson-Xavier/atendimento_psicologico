package com.atendimento.service;

import com.atendimento.exceptionsApp.AtendimentoPsicologicoException;
import com.atendimento.model.Psicologo;
import com.atendimento.repository.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PsicologoService {
    @Autowired
    private PsicologoRepository repository;

    public String cadastrarPsicologo(Psicologo psicologo) {
        Optional<Psicologo> psicologoExistente = repository.findPsicologoByIdUsuario(psicologo.getIdUsuario());
        if (psicologoExistente.isEmpty()) {
            repository.save(psicologo);
            return "Psicologo cadastrado com sucesso";
        } else {
            throw new AtendimentoPsicologicoException("Psicologo já existe", HttpStatus.BAD_REQUEST.value());
        }
    }

    public Psicologo buscarPsicologo(String idUsuario) {
        return repository.findPsicologoByIdUsuario(idUsuario).orElseThrow(() -> new AtendimentoPsicologicoException("Psicologo não encontrado!", HttpStatus.NOT_FOUND.value()));
    }
}
