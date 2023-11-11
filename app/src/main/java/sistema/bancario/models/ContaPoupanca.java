package sistema.bancario.models;

import sistema.bancario.exceptions.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(int numero, Usuario usuario, int senhaDeAcesso) {
		super(numero, usuario, senhaDeAcesso);
	}

	@Override
	public void aplicarTaxa() {
		if (getSaldo() > 0) {
			double juros = super.getSaldo() * 0.02; // 2% do saldo em centavos
			super.setSaldo(super.getSaldo() + (int) juros);
		}
	}

	@Override
	public String getTipo() {
		return "Conta poupança";
	}

	@Override
	public void transferir(Conta contaDestino, int valor) throws SaldoInsuficienteException {
		if (valor > super.getSaldo() || super.getSaldo() == 0) {
			throw new SaldoInsuficienteException();
		} else {
			super.setSaldo(super.getSaldo() - valor);
			contaDestino.depositar(valor);
			super.getExtrato().addTransacao(contaDestino, valor);
		}
	}
}
