package sistema.bancario;
import java.util.Scanner;

import sistema.bancario.validators.ValidationContext;
import sistema.bancario.validators.CPFValidator;
import sistema.bancario.validators.UserPasswordValidator;
import sistema.bancario.validators.UserValidator;
import sistema.bancario.validators.AccountValidator;
import sistema.bancario.validators.AccountPasswordValidator;
import sistema.bancario.validators.NonEmptyValidator;
import sistema.bancario.validators.NonNullOrNegativeValidator;
import sistema.bancario.validators.IntervalValidator;

import sistema.bancario.exceptions.SaldoInsuficienteException;
import sistema.bancario.exceptions.UsuarioExistenteException;
import sistema.bancario.models.Banco;
import sistema.bancario.models.Conta;
import sistema.bancario.models.Usuario;

public class Menu {
	private Controller controlador;
	private String[] listaDeBancos = {"Banco do Brasil", "Bradesco", "Nubank"};

	public Controller getControlador(){
		return this.controlador;
	}

	public void setControlador(Controller controlador){
		this.controlador = controlador;
	}

	public int menu(String titulo, String... opcoes) {
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;

		while (opcao < 1 || opcao > opcoes.length) {
			String barra = "";
			for(int i = 0; i < (37-titulo.length())/2; i++){
				barra += "=";
			}
			System.out.printf("%n%s %s %s%n", barra, titulo, barra);
			System.out.println("|------------------------------------|");

			for (int i = 1; i <= opcoes.length; i++) {
				System.out.printf("|  %d - %s%n", i, opcoes[i - 1]);
			}

			System.out.println("|------------------------------------|\n");

			System.out.print("Opção: ");
			opcao = entrada.nextInt();

			if (opcao < 1 || opcao > opcoes.length) {
				System.out.println("[ERRO]: Opção inválida.");
			}
		}

		return opcao;
	}

	public void bancos() throws Exception {
		int iBanco = menu("Banco", this.controlador.getBancoDeDados().getBancos().stream().map(Banco::getNome).toArray(String[]::new));

		for (int i = 0; i < this.controlador.getBancoDeDados().getBancos().size(); i++) {
			if(iBanco == (i+1)){
				this.controlador.setBanco(this.controlador.getBancoDeDados().getBancos().get(i).getNome());

			}
		}

		login();
	}

	public void login() throws Exception {
		int opcao = menu("Login", "Criar novo usuário", "Entrar com usuário existente", "Voltar");
		Scanner entrada = new Scanner(System.in);

		if (opcao == 1) {
			ValidationContext<String> vcNome = new ValidationContext(new NonEmptyValidator());
			String nome = vcNome.getValidValue("Nome: ", "[ERRO]: Nome inválido.\n", String.class);
			ValidationContext<String> vcCPF = new ValidationContext(new CPFValidator());
			String cpf = vcCPF.getValidValue("CPF: ", "[ERRO]: CPF inválido.\n", String.class);

			try {
				System.out.print("Senha: ");
				String senha = entrada.next();

				this.controlador.setUsuario(this.controlador.criarUsuario(nome, cpf, senha));
				System.out.println("\nUsuário criado com sucesso!");
				System.out.printf("Bem-Vindo, %s!%n", this.controlador.getUsuario(cpf).getNome());
				conta();
			} catch (UsuarioExistenteException e) {
				System.out.println("\n[ERRO]: CPF já cadastrado!");
				login();
			}

		} else if (opcao == 2) {
			ValidationContext<String> vcCPF = new ValidationContext(new UserValidator(this.controlador));
			String cpf = vcCPF.getValidValue("CPF: ", "[ERRO]: Usuário não encontrado.\n", String.class);
			Usuario usuario = this.controlador.getUsuario(cpf);
			ValidationContext<String> vcSenha = new ValidationContext(new UserPasswordValidator(usuario));
			String senha = vcSenha.getValidValue("Senha: ", "[ERRO]: Senha inválida.\n", String.class);

			System.out.println("Usuário logado com sucesso!");
			System.out.printf("Bem-Vindo de volta, %s!%n", this.controlador.getUsuario(cpf).getNome());
			this.controlador.setUsuario(usuario);
			conta();
		} else {
			this.controlador.setUsuario(null);
			bancos();
		}
	}

	public void conta() throws Exception {
		int opcao = menu("Contas", "Criar conta corrente", "Criar conta poupança", "Acessar conta", "Listar minhas contas", "Voltar");
		Scanner entrada = new Scanner(System.in);

		if(opcao == 1 || opcao == 2){
			System.out.print("Senha: ");
			int senha = entrada.nextInt();

			Conta novaConta = this.controlador.criarConta(senha, opcao);
			System.out.printf("Número da conta: %d%n", novaConta.getNumero());
			this.controlador.setContaEmSessao(novaConta);
			acoes();
		} else if(opcao == 3){
			System.out.print("Número da conta: ");
			int numero = entrada.nextInt();

			while(this.controlador.getConta(this.controlador.getBanco().getNome(), numero) == null){
				System.out.println("[ERRO]: Conta não encontrada.\n");

				System.out.print("Número da conta: ");
				numero = entrada.nextInt();
			}
			
			System.out.print("Senha: ");
			int senha = entrada.nextInt();
			Conta conta = this.controlador.getConta(this.controlador.getBanco().getNome(), numero, senha);

			this.controlador.setContaEmSessao(conta);
			acoes();
		} else if(opcao == 4){
			boolean encontrado = false;
			System.out.printf("%n%n--- Minhas contas ---%n");

			for(Conta conta : this.controlador.getBanco().getContas()){
				if(conta.getUsuario() == this.controlador.getUsuario()){
					encontrado = true;
					System.out.printf("%nNúmero: %d%nTipo: %s%nSaldo: R$ %.2f%n%n", conta.getNumero(), conta.getTipo(), conta.getSaldo()/100.0);
				}
			}

			if(!encontrado){
				System.out.printf("%n * Nenhuma conta encontrada * %n%n");
			}

			conta();
		} else {
			login();
		}
	}

	public void acoes() throws Exception {
		int opcao = menu("Ações na conta", "Ver saldo", "Depositar", "Sacar", "Transferir", "Ver extrato", "Encerrar conta", "Voltar");
		Scanner entrada = new Scanner(System.in);

		System.out.println();
		if(opcao == 1){
			System.out.printf("Saldo: R$ %.2f%n", this.controlador.getContaEmSessao().getSaldo()/100.0);
		} else if(opcao == 2){
			ValidationContext<Double> vcValor = new ValidationContext(new NonNullOrNegativeValidator());
			double valor = vcValor.getValidValue("Valor: ", "[ERRO]: Valor inválido.\n", Double.class);
			
			this.controlador.depositar(valor);
			System.out.printf("%nDeposito no valor de R$ %.2f realizado com sucesso!%n", valor);
		} else if(opcao == 3){
			System.out.print("Valor: ");
			double valor = entrada.nextDouble();
			try {
				while(valor <= 0){
					System.out.println("[ERRO]: O Valor deve ser maior que 0.\n");
					System.out.print("Valor: ");
					valor = entrada.nextDouble();
				}
				this.controlador.sacar(valor);
				System.out.printf("%nSaque no valor de R$ %.2f realizado com sucesso!%n", valor);
			} catch (Exception e) {
				System.out.println("\n[ERRO]: Saldo insuficiente!");
				acoes();
			}
		} else if(opcao == 4){
			ValidationContext<Double> vcValor = new ValidationContext(new NonNullOrNegativeValidator());
			double valor = vcValor.getValidValue("Valor: ", "[ERRO]: Valor inválido.\n", Double.class);

			int iBanco = menu("Banco", this.controlador.getBancoDeDados().getBancos().stream().map(Banco::getNome).toArray(String[]::new));

			ValidationContext<Integer> vcConta = new ValidationContext(new AccountValidator(this.controlador, this.controlador.getBancoDeDados().getBancos().get(iBanco - 1).getNome()));
			Integer numero = vcConta.getValidValue("Número da conta destino: ", "[ERRO]: Conta não encontrada.\n", Integer.class);

			Conta contaDestino = this.controlador.getConta(this.controlador.getBancoDeDados().getBancos().get(iBanco - 1).getNome(), numero);

			System.out.println();
			System.out.println("--- Conta-Destino ---");
			System.out.printf("- Titular: %s%n", contaDestino.getUsuario().getNome());
			System.out.printf("- CPF: %s%n", contaDestino.getUsuario().getCPF());
			System.out.printf("- Banco: %s%n", this.controlador.getBancoDeDados().getBancos().get(iBanco - 1).getNome());
			System.out.printf("- Conta: %d (%s)%n%n", contaDestino.getNumero(), contaDestino.getTipo());
			System.out.printf("- Valor da Transferência: R$ %s", valor);
			System.out.printf("\nDigite sua senha para finalizar a transferência.%n");

			ValidationContext<Integer> vcSenha = new ValidationContext(new AccountPasswordValidator(this.controlador.getContaEmSessao()));
			int senha = vcSenha.getValidValue("Senha: ", "[ERRO]: Senha inválida.\n", Integer.class);

			try {
				this.controlador.transferencia(contaDestino, valor);;
				System.out.printf("%nTransferência realizada com sucesso!%n%n");
			} catch (Exception e) {
				System.out.println("\n[ERRO]: Saldo insuficiente!");
				acoes();
			}
		} else if(opcao == 5){
			System.out.println("--- Extrato ---");
			System.out.println(this.controlador.getContaEmSessao().getExtrato().getExtrato());
			System.out.printf("%n- Saldo: R$ %.2f%n", this.controlador.getContaEmSessao().getSaldo()/100.0);

		} else if(opcao == 6){
			if(this.controlador.getContaEmSessao().getSaldo() != 0){
				System.out.println("[ERRO]: Conta tem saldo diferente de 0.");
			} else {
				ValidationContext<Integer> vcConfirmacao = new ValidationContext(new IntervalValidator(1, 2));
				int confirmacao = vcConfirmacao.getValidValue("[AVISO]: Encerrar conta? (1 - sim / 2 - voltar): ", "[ERRO]: Opção inválida.\n", Integer.class);
	
				if(confirmacao == 1){
					ValidationContext<Integer> vcSenha = new ValidationContext(new AccountPasswordValidator(this.controlador.getContaEmSessao()));
					int senha = vcSenha.getValidValue("Senha: ", "[ERRO]: Senha inválida.\n", Integer.class);
					
					this.controlador.encerrarConta();
					System.out.println("\nConta encerrada com sucesso!\n");
					this.controlador.setContaEmSessao(null);
					conta();
					return;
				}
			}
		} else {
			conta();
			return;
		}

		acoes();
	}

	public static void main(String[] args) throws Exception {
		Menu menu = new Menu();
		menu.controlador = new Controller();

		int iBanco = menu.menu("Banco", menu.controlador.getBancoDeDados().getBancos().stream().map(Banco::getNome).toArray(String[]::new));

		for (int i = 0; i < menu.controlador.getBancoDeDados().getBancos().size(); i++) {
		   //  Banco novoBanco = new Banco(menu.listaDeBancos[i]);
		   //  menu.controlador.adicionarBanco(novoBanco);
			if(iBanco == (i+1)){
				menu.controlador.setBanco(menu.controlador.getBancoDeDados().getBancos().get(i).getNome());
			}
		}

		menu.login();
	}
}