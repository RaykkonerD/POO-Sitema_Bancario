package sistema.bancario.GUI.components;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sistema.bancario.Controller;
import sistema.bancario.exceptions.SaldoInsuficienteException;

public class Depositar {

    private JFrame frame;
    private JButton depositarButton;
    private JLabel valorLabel;
    private JTextField valorTextField;

    public Depositar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        frame = new JFrame();
        depositarButton = new JButton();
        valorLabel = new JLabel();
        valorTextField = new JTextField();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        depositarButton.setBackground(new java.awt.Color(51, 51, 51));
        depositarButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        depositarButton.setForeground(new java.awt.Color(255, 255, 255));
        depositarButton.setText("Depositar");
        depositarButton.addActionListener(this::depositarButtonActionPerformed);

        valorLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        valorLabel.setText("Valor do depósito");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(valorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(depositarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(valorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(valorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(depositarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(39, Short.MAX_VALUE))
        );

        frame.pack();
        frame.setVisible(true);
    }

    private void depositarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            double valor = Double.parseDouble(valorTextField.getText());
            Controller.getInstance().depositar(valor);
            this.frame.dispose();
        } catch (NumberFormatException e){
            new ErrorDialog(frame, "Valor inválido!");
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Depositar();
        });
    }
}
