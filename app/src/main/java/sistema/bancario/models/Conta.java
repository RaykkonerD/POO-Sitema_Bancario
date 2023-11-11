package sistema.bancario.models;

import sistema.bancario.exceptions.SaldoInsuficienteException;
import java.io.Serializable;

public abstract class Conta implements ContaIF, Serializable {
    private int numero;
    private Usuario usuario;
    private int saldo;
    private int senhaDeAcesso;
    private Extrato extrato;

    public Conta(int numero, Usuario usuario, int senhaDeAcesso){
        this.numero = numero;
        this.usuario = usuario;
        this.senhaDeAcesso = senhaDeAcesso;
		this.extrato = new Extrato();
    }

	@Override
	public int getNumero(){
		return this.numero;
	}

	@Override
    public void setNumero(int numero) {
        this.numero = numero;
    }

	@Override
    public Usuario getUsuario() {
        return this.usuario;
    }

	@Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	@Override
    public int getSaldo() {
        return this.saldo;
    }

	@Override
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

	@Override
    public int getSenha() {
        return this.senhaDeAcesso;
    }

	@Override
    public void setSenha(int senhaDeAcesso) {
        this.senhaDeAcesso = senhaDeAcesso;
    }

	@Override
    public Extrato getExtrato() {
        return this.extrato;
    }

	@Override
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