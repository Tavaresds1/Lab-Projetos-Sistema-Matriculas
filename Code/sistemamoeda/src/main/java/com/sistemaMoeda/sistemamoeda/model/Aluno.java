package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "aluno")
@Data
@EqualsAndHashCode(callSuper = false)
public class Aluno extends Usuario {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private String departamento;
    private String rq;
    private String endereco;
    private String curso;
    private int saldo;

    @DBRef
    private List<Transacao> extrato;

    @Override
    public void autenticar() {
        // Implementação da autenticação
    }

    public void usarVantagem(Vantagem vantagem) {
        // Implementação do uso de vantagem
    }







}