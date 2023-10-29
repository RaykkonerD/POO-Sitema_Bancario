package models;
import java.util.Random;

import exceptions.SaldoInsuficienteException;

public abstract class Conta implements ContaIF {
    private int numero;
    private Usuario usuario;
    private int saldo;
    private int senhaDeAcesso;
    private Extrato extrato;

    public Conta(Usuario usuario, int senhaDeAcesso){
        this.numero = new Random().nextInt(9000) + 1000;
        this.usuario = usuario;
        this.senhaDeAcesso = senhaDeAcesso;
		this.extrato = new Extrato();
    }

	public int getNumero(){
		return this.numero;
	}
	
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSenha() {
        return this.senhaDeAcesso;
    }

    public void setSenha(int senhaDeAcesso) {
        this.senhaDeAcesso = senhaDeAcesso;
    }

    public Extrato getExtrato() {
        return this.extrato;
    }

    public void setExtrato(Extrato extrato) {
        this.extrato = extrato;
    }

    @Override
    public double verSaldo(){
        return this.saldo / 100.0;
    }

    @Override
    public void depositar(int valor){
        this.saldo += valor;
        extrato.addDeposito(valor);
    }

    @Override
    public void sacar(int valor) throws SaldoInsuficienteException {
        if(valor > this.saldo){
            throw new SaldoInsuficienteException();
        } else {
            this.saldo -= valor;
            extrato.addSaque(valor);
        }
    }

	@Override
	public abstract void transferir(Conta contaDestino, int valor);

    @Override
    public abstract void aplicarTaxa();

	@Override
	public abstract String getTipo();

}