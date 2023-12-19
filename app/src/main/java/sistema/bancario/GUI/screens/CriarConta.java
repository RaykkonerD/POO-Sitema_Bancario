package sistema.bancario.GUI.screens;

import sistema.bancario.Controller;
import sistema.bancario.GUI.components.ErrorDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class CriarConta {

    private JFrame frame;
    private JPanel jPanel1;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel4;
    private JButton jButton2;
    private JButton jButtonCancelar; // New Cancelar button
    private JTextField NomeTextField1;
    private JLabel jLabel9;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel10;

    public CriarConta() {
        initComponents();
        this.frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    private void initComponents() {
        frame = new JFrame();
        NomeTextField1 = new JTextField();
        jLabel9 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jLabel10 = new JLabel();
        jPanel1 = new JPanel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel4 = new JLabel();
        jButton2 = new JButton();
        jButtonCancelar = new JButton(); // Initialize Cancelar button

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NomeTextField1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        NomeTextField1.setToolTipText("Número da conta");

        jLabel9.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel9.setText("Tipo da conta");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Corrente", "Poupança"}));

        // Create a custom renderer for the JComboBox to remove the blue background
        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setBackground(Color.WHITE); // Set background color to white
                setForeground(Color.BLACK); // Set text color to black
                setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add padding
                return this;
            }
        };

        jComboBox1.setRenderer(renderer);

        jLabel10.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel10.setText("Senha da conta");

        jPanel1.setBackground(new Color(51, 51, 51));
        ImageIcon bankIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("CONTA.png")));
        Image image = bankIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        jLabel7.setIcon(new ImageIcon(image));

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
        jLabel8.setText("Criar Conta");

        String text = "<html>Crie sua conta, " + Controller.getInstance().getUsuario().getNome() + "</html>";
        jLabel4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jLabel4.setForeground(new Color(51, 51, 51));
        jLabel4.setText(text);

        jButton2.setBackground(new Color(51, 51, 51));
        jButton2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("Criar conta");
        jButton2.addActionListener(this::CriarConta);

        jButtonCancelar.setBackground(new Color(51, 51, 51));
        jButtonCancelar.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jButtonCancelar.setForeground(new Color(255, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(this::Cancelar);

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NomeTextField1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel4))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NomeTextField1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(5, 5, 5)
                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frame.pack();
        frame.setVisible(true);
    }

    private void CriarConta(ActionEvent evt) {
        if(NomeTextField1.getText().equals("") || !NomeTextField1.getText().matches("[0-9]*")){
            new ErrorDialog(this.frame, "A senha deve conter apenas números");
        } else {
            String tipoDeConta = jComboBox1.getSelectedItem().toString();
            int opcao = (tipoDeConta == "Corrente") ? 1 : 0;
            Integer senha = Integer.parseInt(NomeTextField1.getText());

            Controller.getInstance().setContaEmSessao(Controller.getInstance().criarConta(senha, opcao));
            this.frame.setVisible(false);
            new ContaScreen();
        }
    }

    private void Cancelar(ActionEvent evt) {
        this.frame.setVisible(false);
        SwingUtilities.invokeLater(Banco::new);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new CriarConta());
    }
}
