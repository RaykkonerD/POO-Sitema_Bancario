package sistema.bancario.GUI.screens;

import sistema.bancario.GUI.screens.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Cadastro {

    private JFrame frame;
    private JTextField nomeTextField;
    private JTextField cpfTextField;
    private JTextField senhaTextField;
    private JButton cadastrarButton;
    private JButton backLoginButton;
    private JFrame mainWindow;

    public Cadastro() {
        frame = new JFrame();
        nomeTextField = new JTextField();
        cpfTextField = new JTextField();
        senhaTextField = new JTextField();
        cadastrarButton = new JButton();
        backLoginButton = new JButton();

        initComponents();
    }

    public Cadastro(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        frame = new JFrame();
        nomeTextField = new JTextField();
        cpfTextField = new JTextField();
        senhaTextField = new JTextField();
        cadastrarButton = new JButton();
        backLoginButton = new JButton();

        initComponents();
    }

    private void initComponents() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jLabel4 = new JLabel();
        JPanel jPanel2 = new JPanel();
        JLabel jLabel6 = new JLabel();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabel4.setText("Cadastrar-se");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

         ImageIcon bankIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Bank.png")));
        jLabel6.setIcon(bankIcon);
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel6)
                                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel6)
                                .addContainerGap(150, Short.MAX_VALUE))
        );

        nomeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        nomeTextField.setToolTipText("Número da conta");

        JLabel jLabel7 = new JLabel();
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel7.setText("Nome");

        cpfTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cpfTextField.setToolTipText("Número da conta");

        JLabel jLabel9 = new JLabel();
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel9.setText("CPF");

        JLabel jLabel8 = new JLabel();
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel8.setText("Senha");

        senhaTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        senhaTextField.setToolTipText("Número da conta");

        cadastrarButton.setBackground(new java.awt.Color(51, 51, 51));
        cadastrarButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        cadastrarButton.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(this::jButtonCadastrarActionPerformed);

        backLoginButton.setBackground(java.awt.SystemColor.control);
        backLoginButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        backLoginButton.setForeground(new java.awt.Color(102, 102, 102));
        backLoginButton.setText("Login");
        backLoginButton.setBorder(null);
        backLoginButton.addActionListener(this::jButtonBackLoginActionPerformed);

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(nomeTextField, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                                        .addComponent(cpfTextField, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                                        .addComponent(senhaTextField, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                                        .addComponent(cadastrarButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel9)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(75, 75, 75)
                                                                                .addComponent(backLoginButton)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                                .addGap(146, 146, 146))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel4)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(senhaTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(cadastrarButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backLoginButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frame.pack();
        frame.setVisible(true);
    }

    private void jButtonCadastrarActionPerformed(ActionEvent evt) {
        // TODO add your handling code here
    }

    private void jButtonBackLoginActionPerformed(ActionEvent evt) {
        new Login().main(this.mainWindow);
        // TODO add your handling code here
    }

    public static void main(JFrame mainWindow) {
        SwingUtilities.invokeLater(() -> new Cadastro(mainWindow));
    }
}
