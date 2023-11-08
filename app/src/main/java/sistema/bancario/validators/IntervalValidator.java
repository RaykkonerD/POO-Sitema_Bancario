package validators;

public class IntervalValidator implements Validator<Integer> {
	private Integer min;
	private Integer max;
	
	public IntervalValidator(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public boolean validate(Integer value) {
		return value >= min && value <= max;
	}
}