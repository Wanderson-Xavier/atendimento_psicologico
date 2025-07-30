package com.atendimento.repository;

import com.atendimento.model.Sessao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends MongoRepository<Sessao, String> {
    List<Sessao> findByIdPaciente(String idPaciente);

    List<Sessao> findByIdPsicologo(String idPsicologo);
}