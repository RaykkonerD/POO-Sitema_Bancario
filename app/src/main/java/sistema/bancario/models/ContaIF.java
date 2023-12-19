package sistema.bancario.models;

import sistema.bancario.exceptions.ValorInvalidoException;

public interface ContaIF {
	public int getNumero();
	public void setNumero(int numero);
	public Usuario getUsuario();
	public void setUsuario(Usuario novoUsuario);
	public int getSaldo();
	public void setSaldo(int saldo);
	public int getSenha();
	public void setSenha(int senha);
	public Extrato getExtrato();
	public void setExtrato(Extrato extrato);
    public double verSaldo();
    public void transferir(Conta destino, int valor) throws ValorInvalidoException;
    public void depositar(int valor) throws ValorInvalidoException;
    public void sacar(int valor) throws ValorInvalidoException;
    public void aplicarTaxa();
	public String getTipo();
}