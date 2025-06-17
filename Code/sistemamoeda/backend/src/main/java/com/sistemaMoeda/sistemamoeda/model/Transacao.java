package com.sistemaMoeda.sistemamoeda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.Date;

@Document(collection = "transacoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    @Id
    private String id;

    @NotBlank(message = "O ID do aluno é obrigatório.")
    private String alunoId;

    @NotBlank(message = "O ID do professor é obrigatório.")
    private String professorId;

    @NotNull(message = "A data é obrigatória.")
    private Date data;

    @NotBlank(message = "O tipo é obrigatório.")
    private String tipo;

    @Positive(message = "O valor deve ser positivo.")
    private double valor;

    @Size(max = 255, message = "A mensagem deve ter no máximo 255 caracteres.")
    private String mensagem;

    @NotBlank(message = "O código de confirmação é obrigatório.")
    private String codigoConfirmacao;
}