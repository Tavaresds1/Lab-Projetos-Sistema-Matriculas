package com.sistemaMoeda.sistemamoeda.services;

import com.sistemaMoeda.sistemamoeda.model.Aluno;
import com.sistemaMoeda.sistemamoeda.model.Transacao;
import com.sistemaMoeda.sistemamoeda.model.Vantagem;
import com.sistemaMoeda.sistemamoeda.repository.AlunoRepository;
import com.sistemaMoeda.sistemamoeda.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno buscarPorId(String id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public Aluno buscarPorCpf(String cpf) {
        return alunoRepository.findByCpf(cpf);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno updateAluno(String id, Aluno aluno) {
        Aluno alunoExistente = alunoRepository.findById(id).orElse(null);
        if (alunoExistente != null) {
            aluno.setId(id);
            return alunoRepository.save(aluno);
        }
        return null;
    }

    public void deletarAluno(String id) {
        alunoRepository.deleteById(id);
    }

    public List<Aluno> buscarPorInstituicaoEnsino(String instituicaoEnsino) {
        return alunoRepository.findByInstituicaoEnsino(instituicaoEnsino);
    }

    public List<Aluno> buscarPorCurso(String curso) {
        return alunoRepository.findByCurso(curso);
    }

    public List<Transacao> consultarExtrato(String alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
        return aluno != null ? transacaoRepository.findByAlunoId(alunoId) : null;
    }

    public void resgatarVantagem(String alunoId, Vantagem vantagem) {
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
        if (aluno != null && aluno.getSaldo() >= vantagem.getCusto()) {
            aluno.setSaldo(aluno.getSaldo() - vantagem.getCusto());
            alunoRepository.save(aluno);

            Transacao transacao = new Transacao();
            transacao.setData(new Date());
            transacao.setTipo("RESGATE_VANTAGEM");
            transacao.setValor(vantagem.getCusto());
            transacao.setMensagem("Resgate: " + vantagem.getDescricao());
            transacao.setAlunoId(alunoId);
            transacaoRepository.save(transacao);
        }
    }
}