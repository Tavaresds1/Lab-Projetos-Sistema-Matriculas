package com.sistemaMoeda.sistemamoeda.dto;

import com.sistemaMoeda.sistemamoeda.validation.CPF;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {

    @NotBlank(message = "Usuário é obrigatório")
    private String login;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    @CPF
    private String cpf;

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
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
