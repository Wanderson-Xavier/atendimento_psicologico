package com.atendimento.repository;

import com.atendimento.model.Avaliacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String> {
}