import java.util.ArrayList;

import models.Banco;
import models.Conta;

public class DB {
    private ArrayList<Banco> bancos;

    public DB(){
        this.bancos = new ArrayList<>();
        adicionarBanco(new Banco("Banco do Brasil"));
        adicionarBanco(new Banco("Nubank"));
        adicionarBanco(new Banco("Bradesco"));
    }

    public Banco getBanco(String nome){
        for(Banco banco : bancos){
            if(banco.getNome() == nome){
                return banco;
            }
        }

        return null;
    }

    public ArrayList<Banco> getBancos() {
        return this.bancos;
    }

    public void adicionarBanco(Banco novoBanco){
        this.bancos.add(novoBanco);
    }
}