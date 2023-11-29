package sistema.bancario.GUI.components;

import javax.swing.*;
import java.awt.*;

public class ErrorDialog {

	public ErrorDialog(Component frame, String message) {
		UIManager.put("OptionPane.background", new java.awt.Color(51, 51, 51)); 
		UIManager.put("Panel.background", new java.awt.Color(51, 51, 51));
		UIManager.put("Button.background", Color.WHITE);

		JLabel messageLabel = new JLabel(message);
		messageLabel.setHorizontalAlignment(JLabel.CENTER);
		messageLabel.setVerticalAlignment(JLabel.CENTER);
		messageLabel.setForeground(Color.WHITE); 

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(messageLabel);
		panel.add(Box.createVerticalStrut(10));

		JOptionPane.showMessageDialog(frame, panel, "Erro", JOptionPane.ERROR_MESSAGE);
	}
}
