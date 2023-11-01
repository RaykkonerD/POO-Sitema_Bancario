import exceptions.UsuarioExistenteException;
import models.Banco;
import models.Usuario;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class Controller {
    private DB bancoDeDados;
    private String banco;
    private Usuario usuario;
    private Conta contaEmSessao;

    public Controller() {
        this.bancoDeDados = new DB();

        Thread thread = new Thread(() -> {
            while (true) {
                for(Banco banco : this.bancoDeDados.getBancos()){
                    banco.passouUmMes();
                }

                try {
                    Thread.sleep(30000); // Aguarda 30 segundos
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        thread.start();
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

    public void setContaEmSessao(Conta conta) {
        this.contaEmSessao = conta;
    }

    public Conta getContaEmSessao() {
        return this.contaEmSessao;
    }

    public Usuario getUsuario(String cpf){
        return getBanco(this.banco).getUsuario(cpf);
    }

    public Usuario criarUsuario(String nome, String CPF, String senha) throws Exception {
        if(!(getUsuario(CPF) == null)) {
           throw new UsuarioExistenteException();
        }
        Usuario novoUsuario = new Usuario(nome, CPF, senha);
        getBanco().adicionarUsuario(novoUsuario);
        return novoUsuario;
    }

    public Conta criarConta(int senha, int opcao){
		int numeroDeConta = 0;
		
		while(getBanco().getConta(numero) != null){
			numeroDeConta = new Random().nextInt(9000) + 1000;
		}
		
        Conta novaConta = (opcao == 1) ? new ContaCorrente(numero, getUsuario(), senha) : new ContaPoupanca(numero, getUsuario(), senha);
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
    
    public Conta getConta(String banco, int numero){
        return getBanco(banco).getConta(numero);
    }

}