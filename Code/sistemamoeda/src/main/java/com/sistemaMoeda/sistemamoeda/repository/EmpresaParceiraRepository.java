package com.sistemaMoeda.sistemamoeda.repository;

import com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpresaParceiraRepository extends MongoRepository<EmpresaParceira, String> {
    EmpresaParceira findByNome(String nome);
}