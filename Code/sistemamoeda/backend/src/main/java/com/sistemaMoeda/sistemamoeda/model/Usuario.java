package main.java.com.sistemaMoeda.sistemamoeda.model;


import lombok.Data;

@Data
public abstract class Usuario {
    private String login;
    private String senha;

    public abstract void autenticar();
}
