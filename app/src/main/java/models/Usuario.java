package models;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String CPF;
    private ArrayList<Conta> contas;

    public Usuario(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
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

    public ArrayList<Conta> getContas() {
        return this.contas;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public void criarConta(int senha){
        // Excecao caso senha inválida
        Conta novaConta = new Conta(this, senha);
        addConta(novaConta);
    }
}