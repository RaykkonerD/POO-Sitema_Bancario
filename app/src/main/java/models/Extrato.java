package models;

public class Extrato {
    private String acoes;

    public Extrato() {
        this.acoes = "";
    }

    public void addDeposito(int valor){
        acoes += String.format("- Depósito de R$ %.2f%n", (valor / 100.0));
    }

    public void addSaque(int valor){
        acoes += String.format("- Saque de R$ %.2f%n", (valor / 100.0));
    }

    public void addTransacao(Conta destino, int valor){
        acoes += String.format("- Transação de R$ %.2f%n", (valor / 100.0));
    }

    public String getExtrato(){
        return this.acoes;
    }
}