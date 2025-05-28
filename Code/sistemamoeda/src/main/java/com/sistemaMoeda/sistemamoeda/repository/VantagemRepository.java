package com.sistemaMoeda.sistemamoeda.repository;

import com.sistemaMoeda.sistemamoeda.model.Vantagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VantagemRepository extends MongoRepository<Vantagem, String> {
    List<Vantagem> findByEmpresaParceiraId(String empresaId);
    List<Vantagem> findByCustoLessThanEqual(int custoMaximo);
    boolean existsById(String id);
}
