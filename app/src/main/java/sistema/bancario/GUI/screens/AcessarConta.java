package sistema.bancario.GUI.screens;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import sistema.bancario.Controller;
import sistema.bancario.GUI.components.ErrorDialog;
import sistema.bancario.models.Conta;

public class AcessarConta {

    private javax.swing.JFrame frame;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextField NomeTextField1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton jButtonVoltar1;

    public AcessarConta() {
        initComponents();
    }

    private void initComponents() {
        frame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        NomeTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonVoltar1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Crie sua conta, João Lucas!");

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Criar Conta");

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setToolTipText("");
        jButton5.setActionCommand("CriarConta");
        jButton5.setLabel("Criar conta");
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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel9.setText("Tipo da conta");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Conta: 1324 (Poupança)", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel10.setText("Senha da conta");

        jButtonVoltar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jButtonVoltar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setBorder(null);
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        ImageIcon bankIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Bank.png")));
        jLabel11.setIcon(bankIcon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(86, 86, 86)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addGap(145, 145, 145)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Acesse sua conta, João Lucas.");

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Acessar conta");

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Acessar conta");
        jButton6.setToolTipText("");
        jButton6.setActionCommand("CriarConta");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6CriarConta(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel13.setText("Selecione a conta");
        List<String> contas = Controller.getInstance().getBanco().getContas().stream()
                .filter(c -> c.getUsuario().getCPF().equals(Controller.getInstance().getUsuario().getCPF()))
                .map(c -> "Conta: " + c.getNumero() + " (" + c.getTipo() + ")")
                .collect(Collectors.toList());

        jComboBox2.setModel(new DefaultComboBoxModel<>(contas.toArray(new String[0])));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel14.setText("Senha da conta");

        jButtonVoltar1.setBackground(java.awt.SystemColor.control);
        jButtonVoltar1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jButtonVoltar1.setForeground(new java.awt.Color(51, 51, 51));
        jButtonVoltar1.setText("Voltar");
        jButtonVoltar1.setBorder(null);
        jButtonVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel14)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                .addComponent(jComboBox2,
                                                                        javax.swing.GroupLayout.Alignment.LEADING, 0,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jPasswordField1,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton6,
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 236,
                                                                        Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(132, 132, 132)
                                                .addComponent(jButtonVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel13)
                                .addGap(5, 5, 5)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)));

        frame.pack();
        frame.setVisible(true);
    }

    private void jButton5CriarConta(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NomeTextField1senha(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton6CriarConta(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            int numero = Integer.parseInt(jComboBox2.getSelectedItem().toString().split(" ")[1]);
            int senha = Integer.parseInt(jPasswordField1.getText());

            if(Controller.getInstance().getBanco().getConta(numero, senha) == null){
                new ErrorDialog(frame, "Senha inválida!");
            } else {
                Controller.getInstance().setContaEmSessao(Controller.getInstance().getBanco().getConta(numero, senha));
                this.frame.setVisible(false);
                new ContaScreen();
            }
        } catch (Exception e) {
            new ErrorDialog(frame, "Valores inválidos foram lidos!");
        }
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.frame.setVisible(false);
        new Banco();
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcessarConta();
            }
        });
    }
}
