package models;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Usuario usuario, int senhaDeAcesso) {
        super(usuario, senhaDeAcesso);
    }

    @Override
    public void aplicarTaxa(){
        if(getSaldo() > 0){
            double juros = super.getSaldo() * 0.02; // 2% do saldo em centavos
            super.setSaldo(super.getSaldo() + (int) juros);
        }
    }
}
