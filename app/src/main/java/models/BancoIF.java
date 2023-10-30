package models;
import java.util.ArrayList;

public interface BancoIF {
	public String getNome();
	public Usuario getUsuario(String cpf);
	public Conta getConta(int numero, int senha);
	public ArrayList<Usuario> getUsuarios();
	public void adicionarUsuario(Usuario novoUsuario);
	public ArrayList<Conta> getContas();
	public void adicionarConta(Conta novaConta);
	public void encerrarConta(int nunero);
	void passouUmMes();
}
