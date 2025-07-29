package com.atendimento.repository;

import com.atendimento.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {
    Optional<Paciente> findPacienteByIdUsuario(String idUsuario);
}