package models;

public interface ContaIF {
    public double verSaldo();
    public void transferir(int valor);
    public void depositar(int valor);
    public void sacar(int valor);
}