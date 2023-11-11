package sistema.bancario;
import sistema.bancario.exceptions.UsuarioExistenteException;
import sistema.bancario.models.Banco;
import sistema.bancario.models.Usuario;
import sistema.bancario.models.Conta;
import sistema.bancario.models.ContaCorrente;
import sistema.bancario.models.ContaPoupanca;
import java.util.Random;
import java.util.regex.Pattern;

public class Controller {
    private DB bancoDeDados;
    private String banco;
    private Usuario usuario;
    private Conta contaEmSessao;

    public Controller() {
        this.bancoDeDados = new DB();

        Thread thread = new Thread(() -> {
            while (true) {
                for(Banco banco : this.bancoDeDados.getBancos()){
                    banco.passouUmMes();
                }

                try {
                    Thread.sleep(30000); // Aguarda 30 segundos
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        thread.start();
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Banco getBanco(){
        return getBanco(this.banco);
    }

    public void setBanco(String banco){
        this.banco = banco;
    }

    public void setContaEmSessao(Conta conta) {
        this.contaEmSessao = conta;
    }

    public Conta getContaEmSessao() {
        return this.contaEmSessao;
    }

    public Usuario getUsuario(String cpf){
        return getBanco(this.banco).getUsuario(cpf);
    }

    public Usuario criarUsuario(String nome, String CPF, String senha) throws Exception {
        if(!(getUsuario(CPF) == null)) {
           throw new UsuarioExistenteException();
        }
        Usuario novoUsuario = new Usuario(nome, CPF, senha);
        getBanco().adicionarUsuario(novoUsuario);

		this.bancoDeDados.write();
        return novoUsuario;
    }

    public Conta criarConta(int senha, int opcao){
		int numeroDeConta = new Random().nextInt(9000) + 1000;
		
		while(getBanco().getConta(numeroDeConta) != null){
			numeroDeConta = new Random().nextInt(9000) + 1000;
		}
		
        Conta novaConta = (opcao == 1) ? new ContaCorrente(numeroDeConta, getUsuario(), senha) : new ContaPoupanca(numeroDeConta, getUsuario(), senha);
        getBanco().adicionarConta(novaConta);

		this.bancoDeDados.write();
		return novaConta;
    }

    public Banco getBanco(String nome){
        return getBancoDeDados().getBanco(nome);
    }

    public void adicionarBanco(Banco banco){
        this.bancoDeDados.adicionarBanco(banco);
		this.bancoDeDados.write();
    }

    public DB getBancoDeDados() {
        return this.bancoDeDados;
    }

    public Conta getConta(String banco, int numero, int senha){
        return getBanco(banco).getConta(numero, senha);
    }
    
    public Conta getConta(String banco, int numero){
        return getBanco(banco).getConta(numero);
    }

	public void depositar(Double valor) {
		getContaEmSessao().depositar((int) (valor * 100));
		this.bancoDeDados.write();
	} 

	public void sacar(Double valor) {
		getContaEmSessao().sacar((int) (valor * 100));
		this.bancoDeDados.write();
	} 

	public void transferencia(Conta contaDestino, Double valor) {
		getContaEmSessao().transferir(contaDestino, (int) (valor * 100));
		this.bancoDeDados.write();
	}

	public void encerrarConta() {
		getBanco().encerrarConta(getContaEmSessao().getNumero());
		this.bancoDeDados.write();
	}

	public boolean isCpfValido(String cpf){
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