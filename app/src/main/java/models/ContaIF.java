package models;

public interface ContaIF {
    public double verSaldo();
    public void transferir(Conta destino, int valor);
    public void depositar(int valor);
    public void sacar(int valor);
    public void aplicarTaxa();
}