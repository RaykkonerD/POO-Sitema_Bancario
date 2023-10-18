import java.util.ArrayList;

import models.Usuario;
import models.Conta;

public class DB {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Conta> contas;

    public void adicionarUsuario(Usuario novoUsuario){
        this.usuarios.add(novoUsuario);
    }

    //
}