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
        adicionarUsuario(new Usuario("Cleber", "10210301456", "777"));
    }

    public String getNome(){
        return this.nome;
    }
    
    public Usuario getUsuario(String cpf){
        getUsuarios().forEach(e -> System.out.println(e.getNome()));
        for(Usuario usuario : getUsuarios()){
            if(usuario.getCPF().equals(cpf)){
                System.out.println(usuario.getCPF());
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
        return this.usuarios;
    }

    public void adicionarUsuario(Usuario novoUsuario){
        System.out.println(this);
        this.usuarios.add(novoUsuario);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta novaConta){
        this.contas.add(novaConta);
    }
}
