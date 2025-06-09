package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vantagens")
@Data
public class Vantagem {
    @Id
    private String id;
    private String descricao;
    private String foto;
    private int custo;

    @DBRef
    private EmpresaParceira empresaParceira;
}