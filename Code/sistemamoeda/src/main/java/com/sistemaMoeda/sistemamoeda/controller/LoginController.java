package com.sistemaMoeda.sistemamoeda.controller;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.sistemaMoeda.sistemamoeda.dto.UsuarioDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {
    @PostMapping
    @ResponseBody
    public Object login(@RequestBody @Valid UsuarioDTO usuarioDTO, BindingResult result) {
        if (result.hasErrors()) {
            return result.getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .toList();
        }
        if (usuarioDTO.getEmail() == null || usuarioDTO.getSenha() == null) {
            return "Login ou senha inválidos!";
        }

        return "Login realizado com sucesso!";
    }
}
