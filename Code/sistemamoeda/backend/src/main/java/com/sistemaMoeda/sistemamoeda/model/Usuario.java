package com.sistemaMoeda.sistemamoeda.model;

import com.sistemaMoeda.sistemamoeda.validation.CPF;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@Data
public abstract class Usuario {
    @NotBlank(message = "O login é obrigatório.")
    @Size(max = 50, message = "O login deve ter no máximo 50 caracteres.")
    private String login;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    private String senha;

    @NotBlank(message = "Email é obrigatório.")
    @Email(message = "Email deve ser válido.")
    private String email;

    @CPF
    private String cpf;
    public abstract void autenticar();
}
