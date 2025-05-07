package main.java.com.sistemaMoeda.sistemamoeda.repository;

import main.java.com.sistemaMoeda.sistemamoeda.model.Resgate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResgateRepository extends MongoRepository<Resgate, String> {
}