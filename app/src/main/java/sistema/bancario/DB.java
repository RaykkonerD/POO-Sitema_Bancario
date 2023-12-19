package sistema.bancario;
import java.util.ArrayList;
import java.io.*;

import java.util.Optional;

import sistema.bancario.models.Banco;

public class DB {
    protected ArrayList<Banco> bancos;

    public DB(){
        this.bancos = new ArrayList<>();
		this.bancos.add(new Banco("Banco do Brasil"));
		this.bancos.add(new Banco("Bradesco"));
		this.bancos.add(new Banco("Nubank"));
		
		File data = new File("data.bin");
		if (data.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
					this.bancos = (ArrayList<Banco>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
    }

    public Banco getBanco(String nome){
        Optional<Banco> banco = bancos.stream().filter(b -> b.getNome().equals(nome)).findFirst();
        return banco.orElse(null);
    }

    public ArrayList<Banco> getBancos() {
        return this.bancos;
    }

    public void adicionarBanco(Banco novoBanco){
        this.bancos.add(novoBanco);
    }

	public void write() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
			oos.writeObject(getBancos());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}