package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import com.sistemaMoeda.sistemamoeda.model.Professor;
import com.sistemaMoeda.sistemamoeda.repository.EmpresaParceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginEmpresa")
public class LoginEmpresaController {

    @Autowired
    private EmpresaParceiraRepository EmpresaRepository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody EmpresaParceira loginRequest) {
        if (loginRequest.getEmail() == null || loginRequest.getSenha() == null) {
            return ResponseEntity.badRequest().body("Email e senha são obrigatórios");
        }

        EmpresaParceira empresa = EmpresaRepository.findByEmail(loginRequest.getEmail());

        if (empresa == null || !empresa.getSenha().equals(loginRequest.getSenha())) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }

        return ResponseEntity.ok(empresa); // ou retornar um DTO
    }
}

