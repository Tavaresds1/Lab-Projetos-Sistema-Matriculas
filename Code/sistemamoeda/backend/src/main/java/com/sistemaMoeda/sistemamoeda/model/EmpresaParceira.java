package com.sistemaMoeda.sistemamoeda.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Document(collection = "empresas_parceiras")
@Data
public class EmpresaParceira extends Usuario {
    @Id
    private String id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    private String descricao;


    private List<Vantagem> vantagens;

    public void setSenha(String novaSenha) {
    }

    @Override
    public void autenticar() {
        
    }
}