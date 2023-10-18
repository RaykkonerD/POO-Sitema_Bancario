import java.util.Scanner;

import models.Banco;
import models.Usuario;

public class Menu {

    public static int menu(String titulo, String... opcoes) {
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

    public static Usuario login(String banco, Controller controlador) {
        int opcao = menu("Login", "Criar novo usuário", "Entrar com usuário existente");
        Scanner entrada = new Scanner(System.in);

        if (opcao == 1) {
            System.out.print("Nome: ");
            String nome = entrada.next();
            System.out.print("CPF: ");
            String cpf = entrada.next();

            System.out.println("Usuário criado com sucesso!");
            return controlador.criarUsuario(banco, nome, cpf);
        } else {
            System.out.print("CPF: ");
            String cpf = entrada.next();

            System.out.println("Usuário logado com sucesso!");
            return controlador.getUsuario(banco, cpf);
        }
    }

    public static void conta(String banco, Usuario usuario, Controller controlador) {
        int opcao = menu("Contas", "Criar conta", "Acessar conta");
        Scanner entrada = new Scanner(System.in);

        if(opcao == 1){
            System.out.print("Senha: ");
            int senha = entrada.nextInt();

            controlador.criarConta(usuario, senha);
        } else {
            System.out.print("Número da conta: ");
            int numero = entrada.nextInt();
            System.out.print("Senha: ");
            int senha = entrada.nextInt();

            controlador.getConta(banco, numero, senha);
        }
    }

    public static void main(String[] args) {
        Controller controlador = new Controller();
        Banco banco = null;
        int iBanco = menu("Banco", "Banco do Brasil", "Nubank", "Bradesco");

        switch (iBanco) {
            case 1:
                banco = new Banco("Banco do Brasil");
                break;
            case 2:
                banco = new Banco("Nubank");
                break;
            case 3:
                banco = new Banco("Bradesco");
                break;
        }

        controlador.adicionarBanco(banco);
        Usuario usuario = login(banco.getNome(), controlador);
        conta(banco.getNome(), usuario, controlador);

    }

}