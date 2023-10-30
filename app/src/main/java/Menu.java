import java.util.Scanner;

import exceptions.SaldoInsuficienteException;
import exceptions.UsuarioExistenteException;
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
        int iBanco = menu("BANCO", this.listaDeBancos);

        for (int i = 0; i < this.listaDeBancos.length; i++) {
            if(iBanco == (i+1)){
                this.controlador.setBanco(this.listaDeBancos[i]);

            }
        }

        login();
    }

    public void login() throws Exception {
        int opcao = menu("Login", "Criar novo usuário", "Entrar com usuário existente", "Voltar");
        Scanner entrada = new Scanner(System.in);

        if (opcao == 1) {
            System.out.print("Nome: ");
            String nome = entrada.next();
            System.out.print("CPF: ");
            String cpf = entrada.next();

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
            Usuario usuario = null;
            String senha = null;
            String cpf = null;


            while(usuario == null || !senha.equals(usuario.getSenha())){
                System.out.print("CPF: ");
                cpf = entrada.next();
                System.out.print("Senha: ");
                senha = entrada.next();
                usuario = this.controlador.getUsuario(cpf);

                if(usuario == null){
                    System.out.println("[ERRO]: Usuário não encontrado.");
                }

                System.out.println();
            }

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
            System.out.print("Valor: ");
            double valor = entrada.nextDouble();

            while(valor <= 0){
                System.out.println("[ERRO]: Valor inválido.\n");
                System.out.print("Valor: ");
                valor = entrada.nextDouble();
            }
            this.controlador.getContaEmSessao().depositar((int) (valor * 100));
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
                this.controlador.getContaEmSessao().sacar((int) (valor * 100));
                System.out.printf("%nSaque no valor de R$ %.2f realizado com sucesso!%n", valor);
            } catch (Exception e) {
                System.out.println("\n[ERRO]: Saldo insuficiente!");
                acoes();
            }
        } else if(opcao == 4){
            System.out.print("Valor: ");
            double valor = entrada.nextDouble();

            while(valor <= 0){
                System.out.println("[ERRO]: Valor inválido.\n");
                System.out.print("Valor: ");
                valor = entrada.nextDouble();
            }

            int iBanco = menu("Banco", this.listaDeBancos);

            System.out.print("Número da conta destino: ");
            int numero = entrada.nextInt();

            while (controlador.getConta(listaDeBancos[iBanco-1], numero) == null){
                System.out.println("\n[ERRO]: Conta não encontrada.\n");
                System.out.print("Número da conta destino: ");
                numero = entrada.nextInt();
            }

            Conta contaDestino = this.controlador.getConta(listaDeBancos[iBanco-1], numero);

            System.out.println();
            System.out.println("--- Conta-Destino ---");
            System.out.printf("- Titular: %s%n", contaDestino.getUsuario().getNome());
            System.out.printf("- CPF: %s%n", contaDestino.getUsuario().getCPF());
            System.out.printf("- Banco: %s%n", listaDeBancos[iBanco-1]);
            System.out.printf("- Conta: %d (%s)%n%n", contaDestino.getNumero(), contaDestino.getTipo());
            System.out.printf("- Valor da Transferência: R$ %s", valor);
            System.out.printf("\nDigite sua senha para finalizar a transferência.%n");

            System.out.print("Senha: ");
            int senha = entrada.nextInt();

            while (senha != this.controlador.getContaEmSessao().getSenha()){
                System.out.println("\n[ERRO]: Senha inválida.");
                System.out.print("Senha: ");
                senha = entrada.nextInt();
            }

            try {
                this.controlador.getContaEmSessao().transferir(contaDestino, (int) (valor * 100));
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
            System.out.print("[AVISO]: Encerrar conta? (1 - sim / 2 - voltar): ");
            int confirmacao = entrada.nextInt();

            while(confirmacao != 1 && confirmacao != 2){
                System.out.println("[ERRO]: Opção inválida.");
                confirmacao = entrada.nextInt();
            }

            if(confirmacao == 1){
                this.controlador.getBanco().encerrarConta(this.controlador.getContaEmSessao().getNumero());
                System.out.println("\nConta encerrada com sucesso!\n");
                this.controlador.setContaEmSessao(null);
                conta();
                return;
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