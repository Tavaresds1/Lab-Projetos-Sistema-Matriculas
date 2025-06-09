package com.sistemaMoeda.sistemamoeda.repository;

import com.sistemaMoeda.sistemamoeda.model.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProfessorRepository extends MongoRepository<Professor, String> {
    Professor findByCpf(String cpf);
    Professor findByLogin(String login);
    List<Professor> findByInstituicao(String instituicao);
}