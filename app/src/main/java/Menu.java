import java.util.Scanner;

public class Menu {

    public static void menuInicial(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== Menu ===");
        System.out.println("1 - Criar novo usuário");
        System.out.println("2 - Entrar com usuário existente");
        System.out.print("Opção: ");
        int opcao = entrada.nextInt();

        if(opcao == 1){
            // teste 
        } else if(opcao == 2){

        }

    }

    public static void main(String[] args) {
        Controller controlador = new Controller();
        menuInicial();

    }
    
}