package main.java.com.sistemaMoeda.sistemamoeda.repository;

import main.java.com.sistemaMoeda.sistemamoeda.model.Instituicao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstituicaoRepository extends MongoRepository<Instituicao, String> {
}