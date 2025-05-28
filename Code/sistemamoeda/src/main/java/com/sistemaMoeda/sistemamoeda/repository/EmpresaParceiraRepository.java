package com.sistemaMoeda.sistemamoeda.repository;

import com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaParceiraRepository extends MongoRepository<EmpresaParceira, String> {
    boolean existsById(String id);
    EmpresaParceira findByNome(String nome);
}