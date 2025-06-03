package com.sistemaMoeda.sistemamoeda.dto;

import jakarta.validation.constraints.NotBlank;


public class ProfessorDTO extends UsuarioDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Departamento é obrigatório")
    private String departamento;

    @NotBlank(message = "Instituição é obrigatória")
    private String instituicao;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}