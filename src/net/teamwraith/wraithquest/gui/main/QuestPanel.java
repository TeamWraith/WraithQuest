package net.teamwraith.wraithquest.gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuestPanel extends JPanel{

	private JTextField 	pass = new JTextField("DERp"),
						link = new JTextField("MAN", 15);
	
	private final GridBagConstraints gbc = new GridBagConstraints();
	/**
	 * @param args
	 */
	public QuestPanel() {
		setLayout(new BorderLayout());
		
		setBackground(Color.LIGHT_GRAY);
		add(new JLabel("Password: "), BorderLayout.NORTH);
		add(pass, BorderLayout.CENTER);
		
	}

}
