package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "empresas_parceiras")
@Data
public class EmpresaParceira {
    @Id
    private String id;
    private String nome;
    private List<Vantagem> vantagens;
    private String descricao;

    public void cadastrarVantagem(Vantagem vantagem) {
        // Implementação do cadastro de vantagem
    }
}