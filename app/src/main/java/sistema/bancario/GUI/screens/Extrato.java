package sistema.bancario.GUI.screens;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import sistema.bancario.Controller;

public class Extrato {

    private ExtratoFrame extratoFrame;

    public Extrato() {
        extratoFrame = new ExtratoFrame();
        initComponents();

    }

    private void initComponents() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(extratoFrame.getScrollPane());

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Extrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Extrato();
        });
    }
}

class ExtratoFrame {

    private JButton jButtonVoltar3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTextPane jTextPane1;

    public ExtratoFrame() {
        jButtonVoltar3 = new JButton();
        jScrollPane2 = new JScrollPane();
        jTextPane1 = new JTextPane();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        jButtonVoltar3.setBackground(java.awt.SystemColor.control);
        jButtonVoltar3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonVoltar3.setForeground(new java.awt.Color(51, 51, 51));
        jButtonVoltar3.setText("Cancelar");
        jButtonVoltar3.setBorder(null);

        jScrollPane2.setViewportView(jTextPane1);

        String[] acoes = Controller.getInstance().getContaEmSessao().getExtrato().getExtrato().split("\n");
        Object[][] linhas = new Object[acoes.length][1];

        for (int i = 0; i < acoes.length; i++) {
            linhas[i][0] = acoes[i];
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                linhas,
                new String[]{
                        "Extrato"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
    }

    public JScrollPane getScrollPane() {
        return jScrollPane1;
    }
}
