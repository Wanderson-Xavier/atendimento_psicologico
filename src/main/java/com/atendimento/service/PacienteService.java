package com.atendimento.service;

import com.atendimento.exceptionsApp.AtendimentoPsicologicoException;
import com.atendimento.model.Paciente;
import com.atendimento.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public String cadastrarPaciente(Paciente paciente) {
        Optional<Paciente> pacienteExistente = repository.findPacienteByIdUsuario(paciente.getIdUsuario());
        if (pacienteExistente.isEmpty()) {
            repository.save(paciente);
            return "Paciente cadastrado com sucesso";
        }
        else {
            throw new AtendimentoPsicologicoException("Paciente já existe", HttpStatus.BAD_REQUEST.value());
        }
    }

    public Paciente buscarPaciente(String idUsuario) {
        return repository.findPacienteByIdUsuario(idUsuario).orElseThrow(() -> new AtendimentoPsicologicoException("Paciente não encontrado!", HttpStatus.NOT_FOUND.value()));
    }
}
