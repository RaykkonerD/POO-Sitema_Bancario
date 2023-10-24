import models.Banco;
import models.Usuario;
import models.Conta;

public class Controller {
    private DB bancoDeDados;
    private String banco;
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
        return getBanco(this.banco);
    }

    public void setBanco(String banco){
        this.banco = banco;
    }

    public Usuario getUsuario(String cpf){
        return getBanco(this.banco).getUsuario(cpf);
    }

    public Usuario criarUsuario(String nome, String CPF, String senha){
        Usuario novoUsuario = new Usuario(nome, CPF, senha);
        getBanco().adicionarUsuario(novoUsuario);
        return novoUsuario;
    }

    public void criarConta(int senha){
        // Excecao caso senha inválida
        Conta novaConta = new Conta(getUsuario(), senha);
        getBanco().adicionarConta(novaConta);
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