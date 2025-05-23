package com.sistemaMoeda.sistemamoeda.repository;


import com.sistemaMoeda.sistemamoeda.model.Transacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransacaoRepository extends MongoRepository<Transacao, String> {
    List<Transacao> findByAlunoId(String alunoId);
    List<Transacao> findByProfessorId(String alunoId);
}