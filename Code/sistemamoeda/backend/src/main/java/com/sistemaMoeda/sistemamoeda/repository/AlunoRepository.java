package com.sistemaMoeda.sistemamoeda.repository;

import com.sistemaMoeda.sistemamoeda.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
    Aluno findByCpf(String cpf);
    Aluno findByEmail(String Email);
    List<Aluno> findByInstituicaoEnsino(String instituicaoEnsino);
    List<Aluno> findByCurso(String curso);
}