import java.util.Scanner;

public class Menu {

    public static void login(Controller controlador){
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== Login ===");
        System.out.println("1 - Criar novo usuário");
        System.out.println("2 - Entrar com usuário existente");
        System.out.print("Opção: ");
        int opcao = entrada.nextInt();

        if(opcao == 1){
            System.out.print("Nome: ");
            String nome = entrada.next();
            System.out.println("CPF: ");
            String cpf = entrada.next();

            controlador.criarUsuario(nome, cpf);
            System.out.println("Usuário criado com sucesso!");
        } else if(opcao == 2){

        }

    }

    public static void main(String[] args) {
        Controller controlador = new Controller();
        login(controlador);

    }
    
}

/* import java.util.Scanner;

import models.Usuario;

public class Menu {
    public static Usuario logarUsuario(Controller controlador) {
        // ::: Verificar se usuário existe :::
        System.out.println("=== Login de Usuário ===");
        System.out.print("Nome: ");
        String nome = entrada.next();
        System.out.print("CPF: ");
        String cpf = entrada.next();

        while (controlador.getUsuario(nome, cpf) == null) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("[ERRO]: Usuário inválido.");
            System.out.println("Cadastrar novo usuário? (1 - sim/[outro] - não)");
            int opcao = entrada.nextInt();

            if(opcao == 1){
                return registrarUsuario();
            }

            System.out.println("=== Login de Usuário ===");
            System.out.print("Nome: ");
            nome = entrada.next();
            System.out.print("CPF: ");
            cpf = entrada.next();
        }
        return new Usuario(nome, cpf);
    }

    public static Usuario registrarUsuario() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("Nome: ");
        String nome = entrada.next();
        System.out.print("CPF: ");
        String cpf = entrada.next();

        return new Usuario(nome, cpf);
    }

    public static Usuario menuInicial(Controller controlador){
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 1 && opcao != 2) {
            System.out.println("=== Menu ===");
            System.out.println("1 - Criar novo usuário");
            System.out.println("2 - Entrar com usuário existente");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            if (opcao == 1) {
                return registrarUsuario();
            } else if (opcao == 2) {
                return logarUsuario(controlador);
            } else {
                System.out.println("[ERRO]: Entrada inválida.");
            }
        }
    }

    public static void main(String[] args) {
        Controller controlador = new Controller();
        Scanner entrada = new Scanner(System.in);
        Usuario usuario = menuInicial(controlador);
        
        System.out.printf("Seja bem-vindo(a), %s%n", usuario.getNome());
        int opcao = 0;

        while (opcao != 1 && opcao != 2 && opcao != 3) {
            System.out.println("=== Menu ===");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Consultar conta existente");
            System.out.println("3 - Voltar");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            if (opcao == 1) {
                System.out.print("Senha da conta: ");
                int senha = entrada.nextInt();
                controlador.criarConta(usuario, senha);

                System.out.println("Conta criada com sucesso!");
                opcao = 0;
            } else if (opcao == 2) {
                System.out.print("Senha da conta: ");
                int senha = entrada.nextInt();
                controlador.getConta(usuario, senha);

                // menu de acões na conta
            } else if(opcao == 3){
                usuario = menuInicial();
            } else {
                System.out.println("[ERRO]: Entrada inválida.");
            }
        }
    }

}*/