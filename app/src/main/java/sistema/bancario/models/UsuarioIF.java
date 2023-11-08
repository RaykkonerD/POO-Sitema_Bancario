package sistema.bancario.models;

public interface UsuarioIF {
    public String getNome();
    public void setNome(String nome);
    public String getCPF();
    public void setCPF(String CPF);
    public String getSenha();
    public void setSenha(String senha);
}