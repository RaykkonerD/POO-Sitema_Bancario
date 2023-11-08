package sistema.bancario.exceptions;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(){
        super("Saldo insuficiente.");
    }
}