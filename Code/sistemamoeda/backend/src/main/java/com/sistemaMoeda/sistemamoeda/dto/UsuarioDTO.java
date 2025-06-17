package com.sistemaMoeda.sistemamoeda.dto;

import com.sistemaMoeda.sistemamoeda.validation.CPF;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UsuarioDTO {

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Pattern(regexp = ".+@.+\\..+", message = "Email deve conter um domínio válido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    @CPF
    private String cpf;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
