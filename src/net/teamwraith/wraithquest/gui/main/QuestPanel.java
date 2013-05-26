package net.teamwraith.wraithquest.gui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.teamwraith.wraithquest.files.QuestReader;
import net.teamwraith.wraithquest.files.TaskReader;
import net.teamwraith.wraithquest.files.link.Quest;
import net.teamwraith.wraithquest.files.link.Task;
import net.teamwraith.wraithquest.files.link.WraithFile;

public class QuestPanel extends JPanel {

	private JTextField 	
		pass = new JTextField(18),
		link = new JTextField(18);
	
	private static final Font
		font01 = new Font("Selected", Font.BOLD, 12),
		font02 = new Font("NotSelected", Font.ITALIC, 12);
	
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
		
		link.setEditable(false);
		questDescription.setEditable(false);
		taskDetails.setEditable(false);
		tasks.setModel(new DefaultListModel<Task>());
		
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
		
		pass.addKeyListener(new PasswordKeyListener());
		pass.addFocusListener(new PasswordFocusListener());
		
		link.addMouseListener(new LinkMouseListener());
		
	}

	private class PasswordKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ACCEPT){
				pass.setFocusable(false);
			}
		}
	}
	
	private class PasswordFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			pass.setFont();
		}
		
		@Override
		public void focusLost(FocusEvent e) {
			pass.setFocusable(true);
			pass.setFont();
			for (Task task : QuestReader.getPasswordMatches(pass.getText())) {
				TaskReader.openRelated(task);
			}
			
		}
	}
	
	private class LinkMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			TaskReader.openLink(link.getText());
		}
	}


	public void setLink(String link) {
		this.link.setText(link);
	}

	public void setTasks(Task[] tasks) {
		DefaultListModel<Task> newList = (DefaultListModel<Task>) this.tasks.getModel();
		for (Task task : tasks) {
			newList.addElement(task);
		}
		this.tasks.setModel(newList);
	}

	public void setQuestDescription(String desc) {
		questDescription.setText(desc);
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails.setText(taskDetails);
	}
	
}
