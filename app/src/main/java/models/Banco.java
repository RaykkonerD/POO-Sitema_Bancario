package models;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Conta> contas;
    private String nome;

    public Banco(String nome){
        this.usuarios = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
    
    public Usuario getUsuario(String cpf){
        for(Usuario usuario : getUsuarios()){
            if(usuario.getCPF() == cpf){
                return usuario;
            }
        }

        return null;
    }

    public Conta getConta(int numero, int senha){
        for(Conta conta : contas){
            if(conta.getNumero() == numero && conta.getSenha() == senha){
                return conta;
            }
        }

        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionarUsuario(Usuario novoUsuario){
        this.usuarios.add(novoUsuario);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta novaConta){
        this.contas.add(novaConta);
    }
}
