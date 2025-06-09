package com.sistemaMoeda.sistemamoeda.dto;

import jakarta.validation.constraints.NotBlank;

public class InstituicaoDTO {

    @NotBlank(message = "Nome da instituição é obrigatório")
    private String nome;

    @NotBlank(message = "Endereço da instituição é obrigatório")
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}