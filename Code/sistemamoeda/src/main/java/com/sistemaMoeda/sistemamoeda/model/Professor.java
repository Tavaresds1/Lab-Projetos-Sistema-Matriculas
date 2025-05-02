package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "professore")
@Data
@EqualsAndHashCode(callSuper = false)
public class Professor extends Usuario {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private String departamento;
    private int saldo;

    @DBRef
    private List<Transacao> extrato;

    @Override
    public void autenticar() {
        // Implementação da autenticação
    }

    public void enviaIMoeda(Aluno aluno, int moeda, String mensagem) {
        // Implementação do envio de IMoeda
    }
}