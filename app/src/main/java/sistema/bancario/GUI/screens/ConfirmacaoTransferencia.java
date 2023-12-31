package sistema.bancario.GUI.screens;

import javax.swing.*;

import sistema.bancario.Controller;
import sistema.bancario.GUI.components.ErrorDialog;
import sistema.bancario.exceptions.SaldoInsuficienteException;
import sistema.bancario.exceptions.ValorInvalidoException;
import sistema.bancario.models.Conta;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class ConfirmacaoTransferencia {

    private javax.swing.JFrame frame;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonVoltar4;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private Conta contaDestino;
    private String bancoDestino;
    private Double valor;

    public ConfirmacaoTransferencia(Conta contaDestino, String banco, double valor) {
        this.contaDestino = contaDestino;
        this.bancoDestino = banco;
        this.valor = valor;
        initComponents();
        this.frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }


    private void initComponents() {
        frame = new javax.swing.JFrame();
        jLabel12 = new javax.swing.JLabel();
        jButtonVoltar4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Confirmar");

        jButtonVoltar4.setBackground(java.awt.SystemColor.control);
        jButtonVoltar4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonVoltar4.setForeground(new java.awt.Color(51, 51, 51));
        jButtonVoltar4.setText("Cancelar");
        jButtonVoltar4.setBorder(null);
        jButtonVoltar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltar4(evt);
            }

        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Confirmar");
        jButton6.setToolTipText("");
        jButton6.setActionCommand("CriarConta");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6CriarConta(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Sua senha");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        ImageIcon bankIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Bank.png")));
        jLabel16.setIcon(bankIcon); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(86, 86, 86))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                .addGap(145, 145, 145))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Dados da conta destino:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Nº da conta: " + this.contaDestino.getNumero());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Nome: " + this.contaDestino.getUsuario().getNome());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("CPF: " + this.contaDestino.getUsuario().getCPF());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Banco: " + this.bancoDestino);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(78, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(jButtonVoltar4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel13))
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVoltar4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );

        frame.pack();
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void jButton6CriarConta(java.awt.event.ActionEvent evt) {
        try {
                Controller.getInstance().transferencia(this.contaDestino, this.valor);
                this.frame.setVisible(false);
                new ContaScreen();
        } catch(SaldoInsuficienteException e){
                new ErrorDialog(frame, "Saldo Insuficiente!");
        } catch (ValorInvalidoException e) {
            new ErrorDialog(frame, "Valor inválido!");
        }
    }
    
    private void jButtonVoltar4(ActionEvent evt) {
        this.frame.setVisible(false);
        new ContaScreen();
    }
}
