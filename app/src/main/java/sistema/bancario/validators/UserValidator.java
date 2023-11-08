package validators;
import sistema.bancario.Controller;

public class UserValidator implements Validator<String> {
	private final Controller controlador;
	
	public UserValidator(Controller controlador) {
		this.controlador = controlador;
	}
	
	@Override
	public boolean validate(String cpf){
		return this.controlador.getUsuario(cpf) != null;
	}
}