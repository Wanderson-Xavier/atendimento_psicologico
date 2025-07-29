package com.atendimento.repository;

import com.atendimento.model.Sessao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends MongoRepository<Sessao, String> {
}