package sistema.bancario.GUI.screens;

import sistema.bancario.GUI.screens.*;
import sistema.bancario.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ChooseBank {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton BbButton;
    private JButton BradescoButton;
    private JButton NubankButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;

    public ChooseBank() {
        initComponents();
        this.frame.setLocationRelativeTo(null);
    }

    private void initComponents() {
        frame = new JFrame();
        mainPanel = new JPanel();
        jLabel1 = new JLabel();
        BradescoButton = new JButton();
        NubankButton1 = new JButton();
        BbButton = new JButton();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(new java.awt.Color(51, 255, 153));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24));
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Selecione seu banco");

        BradescoButton.setBackground(new java.awt.Color(255, 51, 51));
        BradescoButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        BradescoButton.setForeground(new java.awt.Color(255, 255, 255));
        BradescoButton.setText("Bradesco");
        BradescoButton.setToolTipText("");
        BradescoButton.addActionListener(this::BradescoButtonActionPerformed);

        NubankButton1.setBackground(new java.awt.Color(102, 0, 204));
        NubankButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        NubankButton1.setForeground(new java.awt.Color(255, 255, 255));
        NubankButton1.setText("Nubank");
        NubankButton1.addActionListener(this::NubankButton1ActionPerformed);

        BbButton.setBackground(new java.awt.Color(255, 255, 102));
        BbButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        BbButton.setForeground(new java.awt.Color(51, 102, 255));
        BbButton.setText("Banco do Brasil");
        BbButton.addActionListener(this::BbButtonActionPerformed);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Bank.png"))));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel2)
                                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel2)
                                .addContainerGap(157, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(NubankButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BbButton, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BradescoButton, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(NubankButton1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(BbButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(BradescoButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Choose Bank");
        frame.getContentPane().add(mainPanel);
        frame.setSize(870, 570);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void BradescoButtonActionPerformed(ActionEvent evt) {
        Controller.getInstance().setBanco("Bradesco");
        this.frame.setVisible(false);
        new Login().main(this.frame);
    }

    private void NubankButton1ActionPerformed(ActionEvent evt) {
        Controller.getInstance().setBanco("Nubank");
        this.frame.setVisible(false);
        new Login().main(this.frame);
    }

    private void BbButtonActionPerformed(ActionEvent evt) {
        Controller.getInstance().setBanco("Banco do Brasil");
        this.frame.setVisible(false);
        new Login().main(this.frame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChooseBank());
    }
}
