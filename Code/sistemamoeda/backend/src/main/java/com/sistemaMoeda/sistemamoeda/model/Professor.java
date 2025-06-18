package com.sistemaMoeda.sistemamoeda.model;

import com.sistemaMoeda.sistemamoeda.model.Transacao;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.List;

@Document(collection = "professor")
@Data
@EqualsAndHashCode(callSuper = false)
public class Professor extends Usuario {
    @Id
    private String id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O departamento é obrigatório.")
    private String departamento;

    @NotBlank(message = "A instituição é obrigatória.")
    private String instituicao;

    @Min(value = 0, message = "O saldo não pode ser negativo.")
    private int saldo;

    @DBRef
    private List<Transacao> extrato;

    @Override
    public void autenticar() {
        // Implementação da autenticação
    }
}