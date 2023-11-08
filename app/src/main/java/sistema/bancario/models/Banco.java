package sistema.bancario.models;
import java.util.ArrayList;
import java.io.Serializable;

public class Banco implements BancoIF, Serializable {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Conta> contas;
    private String nome;

    public Banco(String nome){
        this.usuarios = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.nome = nome;
    }

	@Override
    public String getNome(){
        return this.nome;
    }

	@Override
    public Usuario getUsuario(String cpf){
        for(Usuario usuario : getUsuarios()){
            if(usuario.getCPF().equals(cpf)){
                return usuario;
            }
        }

        return null;
    }

	@Override
    public Conta getConta(int numero, int senha){
        for(Conta conta : contas){
            if(conta.getNumero() == numero && conta.getSenha() == senha){
                return conta;
            }
        }

        return null;
    }

    public Conta getConta(int numero){
        for(Conta conta : getContas()){
            if(conta.getNumero() == numero){
                return conta;
            }
        }

        return null;
    }

	@Override
    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

	@Override
    public void adicionarUsuario(Usuario novoUsuario){        
		this.usuarios.add(novoUsuario);
    }

	@Override
    public ArrayList<Conta> getContas() {
        return contas;
    }

	@Override
    public void adicionarConta(Conta novaConta){
        this.contas.add(novaConta);
    }

	@Override
	public void encerrarConta(int numero){
		this.contas.removeIf(conta -> conta.getNumero() == numero);
	}

    @Override
    public void passouUmMes() {
        for(Conta conta : getContas()){
            conta.aplicarTaxa();
        }
    }
}
