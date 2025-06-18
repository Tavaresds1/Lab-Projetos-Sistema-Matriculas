package com.sistemaMoeda.sistemamoeda.services;

import com.sistemaMoeda.sistemamoeda.model.Aluno;
import com.sistemaMoeda.sistemamoeda.model.Professor;
import com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import com.sistemaMoeda.sistemamoeda.repository.AlunoRepository;
import com.sistemaMoeda.sistemamoeda.repository.ProfessorRepository;
import com.sistemaMoeda.sistemamoeda.repository.EmpresaParceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private EmpresaParceiraRepository empresaParceiraRepository;

    public boolean redefinirSenhaPorEmail(String email, String novaSenha) {
        // Tenta encontrar e atualizar Aluno
        Aluno aluno = alunoRepository.findByEmail(email);
        if (aluno != null) {
            aluno.setSenha(novaSenha);
            alunoRepository.save(aluno);
            return true;
        }
        // Tenta encontrar e atualizar Professor
        Professor professor = professorRepository.findByEmail(email);
        if (professor != null) {
            professor.setSenha(novaSenha);
            professorRepository.save(professor);
            return true;
        }
        // Tenta encontrar e atualizar EmpresaParceira
        EmpresaParceira empresa = empresaParceiraRepository.findByEmail(email);
        if (empresa != null) {
            empresa.setSenha(novaSenha);
            empresaParceiraRepository.save(empresa);
            return true;
        }
        return false;
    }
}