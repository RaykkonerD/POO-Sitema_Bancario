package models;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String CPF;
    private String senha;

    public Usuario(String nome, String CPF, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}