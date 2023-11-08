package sistema.bancario.models;
import java.io.Serializable;

public class Usuario implements UsuarioIF, Serializable {
    private String nome;
    private String CPF;
    private String senha;

    public Usuario(String nome, String CPF, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
    }

	@Override
    public String getNome() {
        return this.nome;
    }

	@Override
    public void setNome(String nome) {
        this.nome = nome;
    }

	@Override
    public String getCPF() {
        return this.CPF;
    }

	@Override
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

	@Override
    public String getSenha() {
        return this.senha;
    }

	@Override
    public void setSenha(String senha) {
        this.senha = senha;
    }
}