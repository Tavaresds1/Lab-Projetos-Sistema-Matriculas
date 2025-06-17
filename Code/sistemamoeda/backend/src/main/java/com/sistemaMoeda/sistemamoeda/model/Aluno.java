package com.sistemaMoeda.sistemamoeda.model;

import com.sistemaMoeda.sistemamoeda.model.Transacao;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.List;

@Document(collection = "aluno")
@Data
@EqualsAndHashCode(callSuper = false)
public class Aluno extends Usuario {
    @Id
    private String id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O RG é obrigatório.")
    private String rg;

    @NotBlank(message = "O endereço é obrigatório.")
    private String endereco;

    @NotBlank(message = "A instituição de ensino é obrigatória.")
    private String instituicaoEnsino;

    @NotBlank(message = "O curso é obrigatório.")
    private String curso;

    @Min(value = 0, message = "O saldo não pode ser negativo.")
    private int saldo;

    @DBRef
    private List<Transacao> extrato;

    @Override
    public void autenticar() {

    }

    public void usarVantagem(Vantagem vantagem) {

    }

    public void setDepartamento(String nome) {

    }
}