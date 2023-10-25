package models;

public class ContaCorrente extends Conta{
    public ContaCorrente(Usuario usuario, int senhaDeAcesso) {
        super(usuario, senhaDeAcesso);
    }

    @Override
    public void aplicarTaxa(){
        if(super.getSaldo() < 0){
            super.setSaldo(getSaldo() - 50);
        }
    }
}
