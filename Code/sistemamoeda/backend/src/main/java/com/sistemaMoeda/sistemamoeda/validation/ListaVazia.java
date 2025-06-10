package com.sistemaMoeda.sistemamoeda.validation; // Crie este pacote se não existir

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD }) // A anotação será usada em campos de classes
@Retention(RetentionPolicy.RUNTIME) // A anotação precisa estar disponível em tempo de execução
@Constraint(validatedBy = ValidarListaVazia.class) // Aponta para a classe que contém a lógica de validação
public @interface ListaVazia {


    String message() default "A lista não pode estar vazia e não pode conter valores em branco.";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}