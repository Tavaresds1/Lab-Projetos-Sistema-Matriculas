package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instituicoes")
@Data
public class Instituicao {
    @Id
    private String id;
    private String nome;
    private String endereco;
}