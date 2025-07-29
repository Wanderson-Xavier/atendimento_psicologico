package com.atendimento.repository;

import java.util.Optional;

import com.atendimento.model.Agenda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends MongoRepository<Agenda, String> {
   Optional<Agenda> findByIdPsicologo(String idPsicologo);
}