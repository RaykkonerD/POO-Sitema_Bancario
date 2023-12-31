package sistema.bancario.GUI.screens;

import javax.swing.*;

import sistema.bancario.Controller;
import sistema.bancario.GUI.components.ErrorDialog;
import sistema.bancario.models.Conta;

import java.util.Objects;

public class Transferencia {
    private JFrame frame;

    public Transferencia() {
        initComponents();
        this.frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    private void initComponents() {

        this.frame = new JFrame();
        jButtonVoltar2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        NomeTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NomeTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonVoltar3 = new javax.swing.JButton();

        jButtonVoltar2.setBackground(new java.awt.Color(51, 51, 51));
        jButtonVoltar2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jButtonVoltar2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVoltar2.setText("Voltar");
        jButtonVoltar2.setBorder(null);

        this.frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        ImageIcon bankIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Bank.png")));
        jLabel7.setIcon(bankIcon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(86, 86, 86)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(145, 145, 145)));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Transferir");

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Continuar");
        jButton5.setToolTipText("");
        jButton5.setActionCommand("CriarConta");
        jButton5.setContentAreaFilled(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5CriarConta(evt);
            }
        });

        NomeTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        NomeTextField1.setToolTipText("Número da conta");
        NomeTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeTextField1senha(evt);
            }
        });
        NomeTextField1.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel9.setText("Valor da transferência");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel10.setText("Número da conta destino");

        NomeTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        NomeTextField2.setToolTipText("Número da conta");
        NomeTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeTextField2senha(evt);
            }
        });
        NomeTextField2.setBorder(null);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel11.setText("Banco da conta destino");

        jComboBox1.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Bradesco", "Banco do Brasil", "Nubank" }));
        jComboBox1.setOpaque(true);

        jButtonVoltar3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonVoltar3.setForeground(new java.awt.Color(51, 51, 51));
        jButtonVoltar3.setText("Cancelar");
        jButtonVoltar3.setBorder(null);
        jButtonVoltar3.setContentAreaFilled(false);
        jButtonVoltar3.setOpaque(true);
        jButtonVoltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltar3(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.frame.getContentPane());
        this.frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jComboBox1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                187,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(NomeTextField1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                187,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel9)
                                                                        .addComponent(jLabel10)
                                                                        .addComponent(NomeTextField2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                187,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel11)))
                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47,
                                                        Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonVoltar3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(126, 126, 126)))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NomeTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NomeTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVoltar3, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)));

        this.frame.pack();
        this.frame.setVisible(true);
    }// </editor-fold>

    private void jButton5CriarConta(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Conta conta = Controller.getInstance().getBanco(jComboBox1.getSelectedItem().toString())
                .getConta(Integer.parseInt(NomeTextField2.getText()));
        if (conta == null) {
            new ErrorDialog(frame, "Conta não encontrada.");
        } else {
               try {
                        Double valor = Double.parseDouble(NomeTextField1.getText());
                        this.frame.dispose();
                        new ConfirmacaoTransferencia(conta, jComboBox1.getSelectedItem().toString(), valor);
               } catch (NumberFormatException e){
                        new ErrorDialog(frame, "Valor Inválido!");
               }
        }
    }

    private void NomeTextField1senha(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NomeTextField2senha(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonVoltar3(java.awt.event.ActionEvent evt) {
        this.frame.setVisible(false);
        new ContaScreen();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transferencia();
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField NomeTextField1;
    private javax.swing.JTextField NomeTextField2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonVoltar2;
    private javax.swing.JButton jButtonVoltar3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
