package sistema.bancario.validators;
import sistema.bancario.models.Usuario;

public class UserPasswordValidator implements Validator<String> {
	private final Usuario usuario;

	public UserPasswordValidator(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean validate(String senha){
		return this.usuario.getSenha().equals(senha);
	}
}