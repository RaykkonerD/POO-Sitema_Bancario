package exceptions;

public class UsuarioExistenteException extends Exception {
    public UsuarioExistenteException() {
        super("Usuario já existente!");
    }
}
