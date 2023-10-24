import models.Banco;
import models.Usuario;
import models.Conta;

public class Controller {
    private DB bancoDeDados;
    private Banco banco;
    private Usuario usuario;

    public Controller() {
        this.bancoDeDados = new DB();
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Banco getBanco(){
        return this.banco;
    }

    public void setBanco(Banco banco){
        this.banco = banco;
    }

    public Usuario getUsuario(String banco, String cpf){
        return getBancoDeDados().getBanco(banco).getUsuario(cpf);
    }

    public Usuario criarUsuario(String nome, String CPF, String senha){
        Usuario novoUsuario = new Usuario(nome, CPF, senha);
        this.banco.adicionarUsuario(novoUsuario);
        return novoUsuario;
    }

    public void criarConta(int senha){
        // Excecao caso senha inválida
        Conta novaConta = new Conta(getUsuario(), senha);
        this.banco.adicionarConta(novaConta);
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