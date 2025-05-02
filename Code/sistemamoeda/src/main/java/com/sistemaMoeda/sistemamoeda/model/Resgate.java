package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "resgates")
@Data
public class Resgate {
    @Id
    private String id;
    private Date data;
    private String codConfirmacao;

    @DBRef
    private Aluno aluno;

    @DBRef
    private Vantagem vantagem;
}