package sistema.bancario.validators;
import sistema.bancario.Controller;
import sistema.bancario.models.Banco;

public class AccountValidator implements Validator<Integer> {
	private final Controller controlador;
	private final String banco;

	public AccountValidator(Controller controlador, String banco) {
		this.controlador = controlador;
		this.banco = banco;
	}

	@Override
	public boolean validate(Integer numero) {
		return this.controlador.getConta(this.banco, numero) != null;
	}
}