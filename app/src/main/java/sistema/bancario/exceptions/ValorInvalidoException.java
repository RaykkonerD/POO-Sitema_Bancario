package sistema.bancario.exceptions;

public class ValorInvalidoException extends Exception {
    public ValorInvalidoException() {
        super("Valor negativo!");
    }
}
