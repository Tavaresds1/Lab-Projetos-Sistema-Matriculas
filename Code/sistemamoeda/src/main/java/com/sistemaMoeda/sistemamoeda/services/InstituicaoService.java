package com.sistemaMoeda.sistemamoeda.services;

import com.sistemaMoeda.sistemamoeda.model.Aluno;
import com.sistemaMoeda.sistemamoeda.model.Instituicao;
import com.sistemaMoeda.sistemamoeda.model.Professor;
import com.sistemaMoeda.sistemamoeda.repository.AlunoRepository;
import com.sistemaMoeda.sistemamoeda.repository.InstituicaoRepository;
import com.sistemaMoeda.sistemamoeda.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public Instituicao criarInstituicao(Instituicao instituicao) {
        return instituicaoRepository.save(instituicao);
    }

    public Aluno criarAluno(String instituicaoId, Aluno aluno) {
        Instituicao instituicao = instituicaoRepository.findById(instituicaoId).orElse(null);
        if (instituicao != null) {
            aluno.setDepartamento(instituicao.getNome());
            return alunoRepository.save(aluno);
        }
        return null;
    }

    public Professor criarProfessor(String instituicaoId, Professor professor) {
        Instituicao instituicao = instituicaoRepository.findById(instituicaoId).orElse(null);
        if (instituicao != null) {
            professor.setDepartamento(instituicao.getNome());
            return professorRepository.save(professor);
        }
        return null;
    }
}