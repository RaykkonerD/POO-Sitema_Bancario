import java.util.ArrayList;

public class Extrato {
    private String acoes;

    public void addDeposito(int valor){
        acoes += "- Depósito de R$ " + (valor / 100) + "\n";
    }

    public void addSaque(int valor){
        acoes += "- Saque de R$ " + (valor / 100) + "\n";
    }

    public void addTransacao(Conta destino, int valor){
        acoes += "- Transação de R$ " + (valor / 100) + "\n";
    }
}