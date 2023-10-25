import models.Banco;
import models.Usuario;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

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
		// Teste
		System.out.println(this.banco);
        return getBanco(this.banco).getUsuario(cpf);
    }

    public Usuario criarUsuario(String nome, String CPF, String senha){
        Usuario novoUsuario = new Usuario(nome, CPF, senha);
        getBanco().adicionarUsuario(novoUsuario);
        return novoUsuario;
    }

    public Conta criarConta(int senha, int opcao){
        // Excecao caso senha inválida
		
        Conta novaConta = (opcao == 1) ? new ContaCorrente(getUsuario(), senha) : new ContaPoupanca(getUsuario(), senha);
        getBanco().adicionarConta(novaConta);
		return novaConta;
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