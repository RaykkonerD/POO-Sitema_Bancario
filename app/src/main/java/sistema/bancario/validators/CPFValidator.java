package sistema.bancario.validators;
import java.util.regex.Pattern;

public class CPFValidator implements Validator<String> {
    private final boolean checkIfExists;

    public CPFValidator() {
        this.checkIfExists = true;
    }

    @Override
    public boolean validate(String cpf) {
		if(cpf.length() != 14 || !Pattern.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}", cpf)){
			return false;
		}

		String cpfNums = cpf.replaceAll("[^0-9]", "");

		int soma1 = 0;

		for(int i = 0; i < 9; i++){
			soma1 += Integer.parseInt(String.valueOf(cpfNums.charAt(i))) * (10 - i);
		}

		int verificador1 = 0;

		if(soma1 % 11 > 1){
			verificador1 = 11 - soma1 % 11;
		}


		int soma2 = 0;

		for(int i = 1; i < 10; i++){
			int t = Integer.parseInt(String.valueOf(cpfNums.charAt(i))) * (11 - i);
			soma2 += t;
		}

		int verificador2 = 0;

		if(soma2 % 11 > 1){
			verificador2 = 11 - soma2 % 11;
		}

		int d1 = Integer.parseInt(String.valueOf(cpfNums.charAt(9)));
		int d2 = Integer.parseInt(String.valueOf(cpfNums.charAt(10)));
		boolean digitosVerificadores = (verificador1 == d1) && (verificador2 == d2);

		return digitosVerificadores;
    }
}