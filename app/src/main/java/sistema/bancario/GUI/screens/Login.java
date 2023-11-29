package sistema.bancario.GUI.screens;

import sistema.bancario.GUI.components.ErrorDialog;
import sistema.bancario.GUI.screens.*;
import sistema.bancario.models.Usuario;
import sistema.bancario.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Login {
    private JFrame frame;
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
    private JFrame mainWindow;

    public Login() {
        initComponents();
    }

    public Login(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame();
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

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Número da conta");
        frame.setPreferredSize(new Dimension(871, 547));

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

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
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

        frame.pack();
    }

    private void ContaTextFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SenhaTextFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        Usuario user = Controller.getInstance().getUsuario(this.ContaTextField.getText());
        if(user == null || !user.getSenha().equals(this.SenhaTextField.getText())){
                new ErrorDialog(this.frame, "CPF ou senha incorretos");
        } else {
                Controller.getInstance().setUsuario(user);
                this.frame.setVisible(false);
                new Banco();
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.frame.setVisible(false);
        new Cadastro(this.mainWindow);
        // TODO add your handling code here:
    }

    private void jButtonVoltarActionPerformed(ActionEvent evt) {
        this.frame.setVisible(false);
        this.mainWindow.setVisible(true);
        // TODO add your handling code here:
    }

    public void showLoginFrame() {
        SwingUtilities.invokeLater(() -> {
            frame.setTitle("Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(871, 547);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static void main(JFrame window) {
        Login login = new Login(window);
        login.showLoginFrame();
    }
}
