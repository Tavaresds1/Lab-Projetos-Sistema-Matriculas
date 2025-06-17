package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "instituicoes")
@Data
public class Instituicao {
    @Id
    private String id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O endereço é obrigatório.")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres.")
    private String endereco;
}