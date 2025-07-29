package com.atendimento.repository;

import com.atendimento.model.Prontuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends MongoRepository<Prontuario, String> {
}