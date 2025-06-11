package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.model.Aluno;
import com.sistemaMoeda.sistemamoeda.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Aluno loginRequest) {
        if (loginRequest.getEmail() == null || loginRequest.getSenha() == null) {
            return ResponseEntity.badRequest().body("Email e senha são obrigatórios");
        }

        Aluno aluno = alunoRepository.findByEmail(loginRequest.getEmail());

        if (aluno == null || !aluno.getSenha().equals(loginRequest.getSenha())) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }

        return ResponseEntity.ok(aluno); // ou retornar um DTO
    }
}

