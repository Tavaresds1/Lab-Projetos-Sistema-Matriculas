package com.sistemaMoeda.sistemamoeda.repository;

import com.sistemaMoeda.sistemamoeda.model.Vantagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface VantagemRepository extends MongoRepository<Vantagem, String> {
    List<Vantagem> findByEmpresaParceiraId(String empresaId);
    List<Vantagem> findByCustoLessThanEqual(int custoMaximo);

}
