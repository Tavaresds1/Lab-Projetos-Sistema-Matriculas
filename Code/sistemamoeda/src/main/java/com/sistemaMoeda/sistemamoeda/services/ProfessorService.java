package com.sistemaMoeda.sistemamoeda.services;

import com.sistemaMoeda.sistemamoeda.model.Aluno;
import com.sistemaMoeda.sistemamoeda.model.Professor;
import com.sistemaMoeda.sistemamoeda.model.Transacao;
import com.sistemaMoeda.sistemamoeda.repository.AlunoRepository;
import com.sistemaMoeda.sistemamoeda.repository.ProfessorRepository;
import com.sistemaMoeda.sistemamoeda.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Professor criarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor buscarPorId(String id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor buscarPorCpf(String cpf) {
        return professorRepository.findByCpf(cpf);
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public Professor updateProfessor(String id, Professor professor){

        Professor professorExistente = professorRepository.findById(id).orElse(null);
        if (professorExistente != null) {
            professor.setId(id);
            return professorRepository.save(professor);
        }
        return null;
    }

    public void deletarProfessor(String id) {
        professorRepository.deleteById(id);
    }

    public List<Transacao> consultarExtrato(String professorId) {
        return transacaoRepository.findByProfessorId(professorId);
    }

    public void enviarIMoeda(String professorId, String alunoId, int valor, String mensagem) {
        Professor professor = professorRepository.findById(professorId).orElse(null);
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);

        if (professor != null && aluno != null && professor.getSaldo() >= valor) {
            professor.setSaldo(professor.getSaldo() - valor);
            aluno.setSaldo(aluno.getSaldo() + valor);

            professorRepository.save(professor);
            alunoRepository.save(aluno);

            Transacao transacaoProfessor = new Transacao();
            transacaoProfessor.setData(new Date());
            transacaoProfessor.setTipo("ENVIO_IMOEDA");
            transacaoProfessor.setValor(valor);
            transacaoProfessor.setMensagem("Envio para " + aluno.getNome() + ": " + mensagem);
            transacaoProfessor.setProfessorId(professorId);
            transacaoRepository.save(transacaoProfessor);

            Transacao transacaoAluno = new Transacao();
            transacaoAluno.setData(new Date());
            transacaoAluno.setTipo("RECEBIMENTO_IMOEDA");
            transacaoAluno.setValor(valor);
            transacaoAluno.setMensagem("Recebido de " + professor.getNome() + ": " + mensagem);
            transacaoAluno.setAlunoId(alunoId);
            transacaoRepository.save(transacaoAluno);
        }
    }
}