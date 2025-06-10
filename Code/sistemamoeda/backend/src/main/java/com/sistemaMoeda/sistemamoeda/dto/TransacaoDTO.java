package com.sistemaMoeda.sistemamoeda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Date;

public class TransacaoDTO {
    @NotBlank(message = "ID do aluno é obrigatório")
    private String alunoId;

    @NotBlank(message = "ID do professor é obrigatório")
    private String professorId;

    //@NotNull(message = "Data não pode ser nula")
    private Date data;

   // @NotBlank(message = "Tipo é obrigatório")
    private String tipo;

    @NotNull(message = "Valor não pode ser nulo")
    @Positive(message = "Valor deve ser positivo")
    private Double valor;

    private String mensagem;
    private String codigoConfirmacao;

    // Getters e Setters
    public String getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(String alunoId) {
        this.alunoId = alunoId;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public @NotNull(message = "Valor não pode ser nulo") @Positive(message = "Valor deve ser positivo") Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCodigoConfirmacao() {
        return codigoConfirmacao;
    }

    public void setCodigoConfirmacao(String codigoConfirmacao) {
        this.codigoConfirmacao = codigoConfirmacao;
    }
}
