package models;
import java.util.Random;

import exceptions.SaldoInsuficienteException;

public class Conta implements ContaIF {
    private int numero;
    private Usuario usuario;
    private int saldo;
    private int senhaDeAcesso;
    private Extrato extrato;

    public Conta(Usuario usuario, int senhaDeAcesso){
        this.numero = new Random().nextInt(7);
        this.usuario = usuario;
        this.senhaDeAcesso = senhaDeAcesso;
    }

    @Override
    public double verSaldo(){
        return this.saldo / 100.0;
    }

    @Override
    public void transferir(Conta contaDestino, int valor) throws SaldoInsuficienteException {
        if(valor > this.saldo){
            throw new SaldoInsuficienteException();
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);
            extrato.addTransacao(contaDestino, valor);
        }
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

    public void encerrarConta(){

    }

    public int getNumero(){
        return this.numero;
    }

}