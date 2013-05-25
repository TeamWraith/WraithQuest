package net.teamwraith.wraithquest.gui.main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.teamwraith.wraithquest.files.link.Task;

public class QuestPanel extends JPanel{

	private JTextField 	
		pass = new JTextField(18),
		link = new JTextField(18);
	
	private JList<Task> tasks = new JList<Task>();
	
	private JTextArea 
		questDescription = new JTextArea(),
		taskDetails = new JTextArea();
	
	private JScrollPane 
		descriptionPane = new JScrollPane(
		questDescription,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
			
		tasksPane = new JScrollPane(
		tasks,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
			
		detailsPane = new JScrollPane(
		taskDetails,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	private final GridBagConstraints gbc = new GridBagConstraints();
	/**
	 * @param args
	 */
	public QuestPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.LIGHT_GRAY);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		add(new JLabel("Password: "), gbc);
		add(pass, gbc);
		gbc.gridy = 1;
		add(new JLabel("Link: "), gbc);
		add(link, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 2;
		gbc.ipady = 100;
		gbc.gridy = 2;
		add(descriptionPane, gbc);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridy = 3;
		add(tasksPane, gbc);
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridy = 4;
		add(detailsPane, gbc);
		
	}

}
