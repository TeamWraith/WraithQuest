package net.teamwraith.wraithquest.gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuestPanel extends JPanel{

	private JTextField 	pass = new JTextField(16),
						link = new JTextField(16);
	
	private final GridBagConstraints gbc = new GridBagConstraints();
	/**
	 * @param args
	 */
	public QuestPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.LIGHT_GRAY);
		add(new JLabel("Password: "), gbc);
		add(pass, gbc);
		gbc.gridy=1;
		add(new JLabel("Link: "), gbc);
		add(link, gbc);
		
	}

}
