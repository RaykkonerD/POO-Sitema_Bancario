import models.Banco;
import models.Usuario;
import models.Conta;

public class Controller {
    private DB bancoDeDados;

    public Controller() {
        this.bancoDeDados = new DB();
    }

    public Usuario getUsuario(String banco, String cpf){
        return getBancoDeDados().getBanco(banco).getUsuario(cpf);
    }

    public Usuario criarUsuario(String banco, String nome, String CPF){
        Usuario novoUsuario = new Usuario(nome, CPF);
        this.bancoDeDados.getBanco(banco).adicionarUsuario(novoUsuario);
        return novoUsuario;
    }

    public void criarConta(Banco banco, Usuario usuario, int senha){
        // Excecao caso senha inválida
        Conta novaConta = new Conta(usuario, senha);
        banco.adicionarConta(novaConta);
    }

    public Banco getBanco(String nome){
        return getBancoDeDados().getBanco(nome);
    }

    public void adicionarBanco(Banco banco){
        this.bancoDeDados.adicionarBanco(banco);
    }

    public DB getBancoDeDados() {
        return this.bancoDeDados;
    }

    public Conta getConta(String banco, int numero, int senha){
        return getBanco(banco).getConta(numero, senha);
    }

}