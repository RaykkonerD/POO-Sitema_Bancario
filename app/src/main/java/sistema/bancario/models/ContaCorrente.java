package sistema.bancario.models;

import sistema.bancario.exceptions.ValorInvalidoException;

public class ContaCorrente extends Conta{
    public ContaCorrente(int numero, Usuario usuario, int senhaDeAcesso) {
        super(numero, usuario, senhaDeAcesso);
    }

    @Override
    public void aplicarTaxa(){
        if(super.getSaldo() < 0){
            super.setSaldo(getSaldo() - 50);
        }
    }
    
    @Override
    public void transferir(Conta contaDestino, int valor) throws ValorInvalidoException {
        super.setSaldo(super.getSaldo() - valor);
        contaDestino.depositar(valor);
        super.getExtrato().addTransacao(contaDestino, valor);
    }

    @Override
    public void sacar(int valor) {
        super.setSaldo(super.getSaldo() - valor);
        super.getExtrato().addSaque(valor);
    }

	@Override
	public String getTipo(){
		return "Conta corrente";
	}
}
