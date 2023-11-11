package sistema.bancario.validators;
import sistema.bancario.models.Conta;

public class AccountPasswordValidator implements Validator<Integer> {
	private final Conta conta;

	public AccountPasswordValidator(Conta conta) {
		this.conta = conta;
	}

	@Override
	public boolean validate(Integer senha) {
		return this.conta.getSenha() == senha;
	}
}