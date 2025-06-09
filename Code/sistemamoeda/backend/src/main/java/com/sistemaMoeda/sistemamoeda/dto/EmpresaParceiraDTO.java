package com.sistemaMoeda.sistemamoeda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class EmpresaParceiraDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Vantagens não pode ser nulo")
    private List<VantagemDTO> vantagens;

    private String descricao;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<VantagemDTO> getVantagens() {
        return vantagens;
    }

    public void setVantagens(List<VantagemDTO> vantagens) {
        this.vantagens = vantagens;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
