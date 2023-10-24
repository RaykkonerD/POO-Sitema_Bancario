import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import models.Banco;
import models.Conta;
import models.Usuario;

public class Menu {
    private Controller controlador;

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

    public Usuario login() {
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
            return this.controlador.criarUsuario(nome, cpf, senha);
        } else if (opcao == 2) {
            Usuario usuario = null;
            String senha = null;
            

            while(usuario == null || !senha.equals(usuario.getSenha())){
                System.out.print("CPF: ");
                String cpf = entrada.next();
                System.out.print("Senha: ");
                senha = entrada.next();
                usuario = this.controlador.getUsuario(cpf);
            }

            System.out.println("Usuário logado com sucesso!");
            return usuario;
        } else {
            return null;
        }
    }

    public void conta() {
        int opcao = menu("Contas", "Criar conta", "Acessar conta", "Voltar");
        Scanner entrada = new Scanner(System.in);

        if(opcao == 1){
            System.out.print("Senha: ");
            int senha = entrada.nextInt();

            this.controlador.criarConta(senha);
        } else if(opcao == 2){
            System.out.print("Número da conta: ");
            int numero = entrada.nextInt();
            System.out.print("Senha: ");
            int senha = entrada.nextInt();
            Conta conta = this.controlador.getConta(this.controlador.getBanco().getNome(), numero, senha);

            // this.controlador.getConta(banco.getNome(), numero, senha);
        } else {
            login();
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.controlador = new Controller();
        String[] listaDeBancos = {"Banco do Brasil", "Bradesco", "Nubank"};
        int iBanco = menu.menu("Banco", listaDeBancos);

        for (int i = 0; i < listaDeBancos.length; i++) {
            Banco novBanco = new Banco(listaDeBancos[i]);
            menu.controlador.adicionarBanco(novBanco);
            if(iBanco == (i+1)){
                menu.controlador.setBanco(listaDeBancos[i]);
            }
        }

        menu.controlador.setUsuario(menu.login());
        menu.conta();

    }

}