package models;
import java.io.Serializable;

public class Extrato implements Serializable {
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
        acoes += String.format("- Tranferência de R$ %.2f para conta %d%n", (valor / 100.0), destino.getNumero());
    }

    public String getExtrato(){
        return this.acoes;
    }
}