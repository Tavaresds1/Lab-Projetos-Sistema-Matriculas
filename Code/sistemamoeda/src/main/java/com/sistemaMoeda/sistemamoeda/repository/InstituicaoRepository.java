package com.sistemaMoeda.sistemamoeda.repository;

import com.sistemaMoeda.sistemamoeda.model.Instituicao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstituicaoRepository extends MongoRepository<Instituicao, String> {
}