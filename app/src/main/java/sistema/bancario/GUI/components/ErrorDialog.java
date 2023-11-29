package sistema.bancario.GUI.components;

import javax.swing.*;
import java.awt.*;

public class ErrorDialog {

	public ErrorDialog(Component frame, String message) {
		UIManager.put("OptionPane.background", new java.awt.Color(51, 51, 51)); 
		UIManager.put("Panel.background", new java.awt.Color(51, 51, 51));
		UIManager.put("Button.background", Color.WHITE);

		JLabel messageLabel = new JLabel(message);
		// messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		messageLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		messageLabel.setForeground(Color.WHITE); 

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		panel.add(messageLabel);
        // panel.setPreferredSize(new Dimension(150, 75));

		JOptionPane.showMessageDialog(frame, panel, "Erro", JOptionPane.ERROR_MESSAGE);
	}
}
