// src/main/java/com/sistemaMoeda/sistemamoeda/controller/PasswordResetController.java
package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.services.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/senha")
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;

    @PutMapping("/solicitar")
    public String redefinirSenhaPorEmail(@RequestParam String email, @RequestParam String novaSenha) {
        boolean sucesso = passwordResetService.redefinirSenhaPorEmail(email, novaSenha);
        return sucesso ? "Senha redefinida com sucesso" : "Usuário não encontrado";
    }
}