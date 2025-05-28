package com.sistemaMoeda.sistemamoeda.dto;

import com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VantagemDTO {
    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    private String foto;

    @NotNull(message = "Custo não pode ser nulo")
    @Positive(message = "Custo deve ser um valor positivo")
    private Integer custo;

    @NotNull(message = "Empresa Parceira é obrigatória")
    private EmpresaParceira empresaParceira;

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    public EmpresaParceira getEmpresaParceira() {
        return empresaParceira;
    }

    public void setEmpresaParceira(EmpresaParceira empresaParceira) {
        this.empresaParceira = empresaParceira;
    }
}
