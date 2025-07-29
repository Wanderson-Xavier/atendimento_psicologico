package com.atendimento.repository;

import com.atendimento.model.Psicologo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PsicologoRepository extends MongoRepository<Psicologo, String> {
    Optional<Psicologo> findPsicologoByIdUsuario(String idUsuario);
}