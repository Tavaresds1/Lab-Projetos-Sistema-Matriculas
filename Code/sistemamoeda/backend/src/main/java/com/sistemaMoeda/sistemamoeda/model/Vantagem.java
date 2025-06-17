package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "vantagens")
@Data
public class Vantagem {
    @Id
    private String id;

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    @NotBlank(message = "A foto é obrigatória.")
    private String foto;

    @Min(value = 0, message = "O custo deve ser maior ou igual a zero.")
    private int custo;

    @NotNull(message = "A empresa parceira é obrigatória.")
    @DBRef
    private EmpresaParceira empresaParceira;
}