package sistema.bancario.GUI.screens;

import javax.swing.*;
import sistema.bancario.Controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Banco {

    private JFrame frame;
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JPanel jPanel1;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel4;
    private JButton jButton5;
    private JButton jButton2;
    private JButton jButton6;
    private JFrame mainWindow;

    public Banco() {
        initComponents();
        this.frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }



    private void initComponents() {
        frame = new JFrame();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel1 = new JPanel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel4 = new JLabel();  // Inicializando jLabel4
        jButton5 = new JButton();
        jButton2 = new JButton();
        jButton6 = new JButton();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new Color(51, 51, 51));
        jButton1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jButton1.setText("Entrar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new Color(51, 51, 51));
        ImageIcon bankIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Bank.png")));
        jLabel7.setIcon(bankIcon);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(145, 145, 145))
        );

        jLabel8.setBackground(new Color(51, 51, 51));
        jLabel8.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel8.setForeground(new Color(51, 51, 51));
        jLabel8.setText(Controller.getInstance().getBanco().getNome());

        jButton5.setBackground(new Color(51, 51, 51));
        jButton5.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jButton5.setForeground(new Color(255, 255, 255));
        jButton5.setText("Sair");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jButton2.setBackground(new Color(51, 51, 51));
        jButton2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("Criar conta");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton6.setBackground(new Color(51, 51, 51));
        jButton6.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jButton6.setForeground(new Color(255, 255, 255));
        jButton6.setText("Acessar conta");
        jButton6.addActionListener(this::jButton6ActionPerformed);

        // Usando HTML para quebrar linha no JLabel
        String welcomeText = "<html>Bem Vindo, " + Controller.getInstance().getUsuario().getNome() + "!</html>";
        jLabel4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jLabel4.setForeground(new Color(51, 51, 51));
        jLabel4.setText(welcomeText);

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton5, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel4)))
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(73, 73, 73)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        frame.pack();
        frame.setVisible(true);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        // SAIR
        this.frame.setVisible(false);
        SwingUtilities.invokeLater(ChooseBank::new);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.frame.setVisible(false);
        new CriarConta();
    }

    private void jButton6ActionPerformed(ActionEvent evt) {
        // ACESSAR CONTA
        this.frame.setVisible(false);
        new AcessarConta();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new Banco());
    }
}




