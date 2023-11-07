package validators;

public class NonNullOrNegativeValidator implements Validator<Double> {
	@Override
	public boolean validate(Double data) {
		return data > 0;
	}
}