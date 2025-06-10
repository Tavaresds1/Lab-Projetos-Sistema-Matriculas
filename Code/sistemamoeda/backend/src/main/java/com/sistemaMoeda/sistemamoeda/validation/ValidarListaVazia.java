package com.sistemaMoeda.sistemamoeda.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidarListaVazia implements ConstraintValidator<ListaVazia, List<String>> {

    @Override
    public boolean isValid(List<String> list, ConstraintValidatorContext context) {

        if (list == null || list.isEmpty()) {
            return false;
        }


        boolean containsBlankString = list.stream()
                .anyMatch(s -> s == null || s.trim().isEmpty());


        return !containsBlankString;
    }
}