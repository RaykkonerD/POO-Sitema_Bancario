import models.Usuario;

public class Controller {
    private DB bancoDeDados;

    public Controller() {
        this.bancoDeDados = new DB();
    }

    public void criarUsuario(String nome, String CPF){
        Usuario novoUsuario = new Usuario(nome, CPF);
        bancoDeDados.adicionarUsuario(novoUsuario);
    }

    public void criarConta(Usuario usuario, int senha){
        usuario.criarConta(senha);
    }

}