package com.sistemaMoeda.sistemamoeda.services;

import com.sistemaMoeda.sistemamoeda.model.Transacao;
import com.sistemaMoeda.sistemamoeda.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao criarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarPorAluno(String alunoId) {
        return transacaoRepository.findByAlunoId(alunoId);
    }

    public List<Transacao> listarPorProfessor(String professorId) {
        return transacaoRepository.findByProfessorId(professorId);
    }

    public void deletarTransacao(String id) {transacaoRepository.deleteById(id);}

    public List<Transacao> listarTodas() {
        return transacaoRepository.findAll();
    }
}