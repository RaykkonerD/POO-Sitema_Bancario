package sistema.bancario.GUI.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Login extends JFrame {
    private JTextField ContaTextField;
    private JTextField SenhaTextField;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButtonVoltar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JPanel jPanel1;

    public Login() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        jLabel5 = new JLabel();
        jButtonVoltar = new JButton();
        ContaTextField = new JTextField();
        jLabel2 = new JLabel();
        SenhaTextField = new JTextField();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Número da conta");
        setPreferredSize(new Dimension(871, 547));

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 36));
        jLabel1.setText("Login");

        jPanel1.setBackground(new Color(51, 51, 51));

        ImageIcon bankIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Bank.png")));
        jLabel5.setIcon(bankIcon);

        jButtonVoltar.setBackground(new Color(51, 51, 51));
        jButtonVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jButtonVoltar.setForeground(new Color(255, 255, 255));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setBorder(null);
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel5))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jButtonVoltar)))
                                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButtonVoltar)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel5)
                                .addContainerGap(190, Short.MAX_VALUE))
        );

        ContaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        ContaTextField.setToolTipText("Número da conta");
        ContaTextField.addActionListener(this::ContaTextFieldActionPerformed);

        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel2.setText("CPF");

        SenhaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        SenhaTextField.setToolTipText("Número da conta");
        SenhaTextField.addActionListener(this::SenhaTextFieldActionPerformed);

        jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel3.setText("Senha");

        jButton1.setBackground(new Color(51, 51, 51));
        jButton1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Entrar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setBackground(SystemColor.control);
        jButton2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jButton2.setForeground(new Color(102, 102, 102));
        jButton2.setText("Criar conta");
        jButton2.setBorder(null);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel1)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ContaTextField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(SenhaTextField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3))
                                                                .addGap(146, 146, 146))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jButton2)
                                                                .addGap(203, 203, 203))))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ContaTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SenhaTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void ContaTextFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SenhaTextFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonVoltarActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login loginFrame = new Login();
            loginFrame.setTitle("Login");
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setSize(871, 547);
            loginFrame.setResizable(false);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setVisible(true);
        });
    }
}
