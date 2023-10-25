package models;

public class ContaPolpanca extends Conta {
    public ContaPolpanca(Usuario usuario, int senhaDeAcesso) {
        super(usuario, senhaDeAcesso);
    }

    @Override
    public void setSaldo(int saldo) {
        super.setSaldo(saldo);
        render();
    }

    public void render() {
        Thread thread = new Thread(() -> {
            while (true) {
                double juros = super.getSaldo() * 0.02; // 2% do saldo em centavos
                super.setSaldo(super.getSaldo() + (int) juros);
                try {
                    Thread.sleep(10000); // Aguarda 10 segundos
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        thread.start();
    }
}
