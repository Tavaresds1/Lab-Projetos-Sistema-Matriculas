package com.sistemaMoeda.sistemamoeda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "transacoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    @Id
    private String id;
    private String alunoId;
    private String professorId;
    private Date data;
    private String tipo;
    private int valor;
    private String mensagem;
    private String codigoConfirmacao;
}