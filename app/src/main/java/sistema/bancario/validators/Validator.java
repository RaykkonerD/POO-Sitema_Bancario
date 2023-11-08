package sistema.bancario.validators;

public interface Validator<T> {
    boolean validate(T data);
}