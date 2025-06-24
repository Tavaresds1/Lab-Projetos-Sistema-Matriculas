package com.sistemaMoeda.sistemamoeda.dto;

import com.sistemaMoeda.sistemamoeda.validation.ListaVazia;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class
ResgatarVantagemDTO {
    @NotBlank(message = "O ID do aluno é obrigatório")
    private String alunoId;

    @ListaVazia(message = "É necessário selecionar pelo menos uma vantagem.")
    private List<String> vantagensIds;


    public String getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(String alunoId) {
        this.alunoId = alunoId;
    }

    public List<String> getVantagensIds() {
        return vantagensIds;
    }

    public void setVantagensIds(List<String> vantagensIds) {
        this.vantagensIds = vantagensIds;
    }
}