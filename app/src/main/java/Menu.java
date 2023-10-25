import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import models.Banco;
import models.Conta;
import models.Usuario;

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
            System.out.printf("%n=== %s ===%n", titulo);

            for (int i = 1; i <= opcoes.length; i++) {
                System.out.printf("%d - %s%n", i, opcoes[i - 1]);
            }

            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            if (opcao < 1 || opcao > opcoes.length) {
                System.out.println("[ERRO]: Opção inválida.");
            }
        }

        return opcao;
    }

    public void bancos(){
		int iBanco = menu("Banco", this.listaDeBancos);

        for (int i = 0; i < this.listaDeBancos.length; i++) {
	
            if(iBanco == (i+1)){
                 this.controlador.setBanco(this.listaDeBancos[i]);
                
		    }
		}
		
		login();
	}

    public void login() {
        int opcao = menu("Login", "Criar novo usuário", "Entrar com usuário existente", "Voltar");
        Scanner entrada = new Scanner(System.in);

        if (opcao == 1) {
            System.out.print("Nome: ");
            String nome = entrada.next();
            System.out.print("CPF: ");
            String cpf = entrada.next();
            System.out.print("Senha: ");
            String senha = entrada.next();

            System.out.println("Usuário criado com sucesso!");
            this.controlador.setUsuario(this.controlador.criarUsuario(nome, cpf, senha));
			conta();
        } else if (opcao == 2) {
            Usuario usuario = null;
            String senha = null;
            

            while(usuario == null || !senha.equals(usuario.getSenha())){
                System.out.print("CPF: ");
                String cpf = entrada.next();
                System.out.print("Senha: ");
                senha = entrada.next();
                usuario = this.controlador.getUsuario(cpf);
				
				if(usuario == null){
					System.out.println("[ERRO]: Usuário não encontrado.");
				}
				
				System.out.println();
            }

            System.out.println("Usuário logado com sucesso!");
            this.controlador.setUsuario(usuario);
			conta();
        } else {
			this.controlador.setUsuario(null);
			bancos();
        }
    }

    public void conta() {
        int opcao = menu("Contas", "Criar conta corrente", "Criar conta poupança", "Acessar conta", "Voltar");
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
            System.out.print("Senha: ");
            int senha = entrada.nextInt();
            Conta conta = this.controlador.getConta(this.controlador.getBanco().getNome(), numero, senha);

            this.controlador.setContaEmSessao(conta);
            acoes();
        } else {
            login();
        }
    }

	public void acoes(){
		int opcao = menu("Ações na conta", "Ver saldo", "Depositar", "Sacar", "Transferir", "Ver extrato", "Voltar");
		Scanner entrada = new Scanner(System.in);

        System.out.println();
		if(opcao == 1){
			System.out.printf("Saldo: R$ %.2f%n", this.controlador.getContaEmSessao().getSaldo()/100.0);
		} else if(opcao == 2){
			System.out.print("Valor: ");
			double valor = entrada.nextDouble();
			this.controlador.getContaEmSessao().depositar((int) valor*100);
		} else if(opcao == 3){
			System.out.print("Valor: ");
			double valor = entrada.nextDouble();
			this.controlador.getContaEmSessao().sacar((int) valor*100);
		
		} else if(opcao == 4){
			System.out.print("Valor: ");
			double valor = entrada.nextDouble();

            int iBanco = menu("Banco", this.listaDeBancos);

			System.out.print("Número da conta destino: ");
			int numero = entrada.nextInt();
			System.out.print("Senha: ");
			int senha = entrada.nextInt();

            while(senha != this.controlador.getContaEmSessao().getSenha()){
                System.out.println("[ERRO]: Senha inválida.");
            }
            
            Conta contaDestino = this.controlador.getConta(listaDeBancos[iBanco-1], numero);
			this.controlador.getContaEmSessao().transferir(contaDestino, (int) valor*100);
		} else if(opcao == 5){
            System.out.println("--- Extrato ---");
			System.out.println(this.controlador.getContaEmSessao().getExtrato());
		
		} else {
			conta();
			return ;
		}
		
		acoes();
	}

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.controlador = new Controller();
        int iBanco = menu.menu("Banco", menu.listaDeBancos);

        for (int i = 0; i < menu.listaDeBancos.length; i++) {
            Banco novoBanco = new Banco(menu.listaDeBancos[i]);
            menu.controlador.adicionarBanco(novoBanco);
            if(iBanco == (i+1)){
                menu.controlador.setBanco(menu.listaDeBancos[i]);
            }
        }

        menu.login();

    }

}