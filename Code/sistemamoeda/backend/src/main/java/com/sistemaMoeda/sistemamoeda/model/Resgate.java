package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "resgates")
@Data
public class Resgate {
    @Id
    private String id;

    @NotNull(message = "A data é obrigatória.")
    private Date data;

    @NotBlank(message = "O código de confirmação é obrigatório.")
    private String codConfirmacao;

    @NotNull(message = "O aluno é obrigatório.")
    @DBRef
    private Aluno aluno;

    @NotNull(message = "A vantagem é obrigatória.")
    @DBRef
    private Vantagem vantagem;
}