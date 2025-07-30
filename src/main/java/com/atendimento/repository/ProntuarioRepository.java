package com.atendimento.repository;

import com.atendimento.model.Prontuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProntuarioRepository extends MongoRepository<Prontuario, String> {
    List<Prontuario> findProntuarioByIdSessao(String idSessao);
}