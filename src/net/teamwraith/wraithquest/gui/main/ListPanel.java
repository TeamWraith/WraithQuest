package net.teamwraith.wraithquest.gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import net.teamwraith.wraithquest.files.WraithFile;
import net.teamwraith.wraithquest.files.link.Quest;

public class ListPanel extends JPanel{

	private JList 	activeQuests = new JList(), 
					finishedQuests = new JList();
	
	/**
	 * @param args
	 */
	public ListPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.GRAY);
		add(activeQuests, BorderLayout.CENTER);
		add(finishedQuests, BorderLayout.SOUTH);
	}
	
	public JList getActiveQuests() {
		return activeQuests;
	}
	public void setActiveQuests(WraithFile[] activeQuests) {
		DefaultListModel listModel = new DefaultListModel();
		for (WraithFile file : activeQuests) {
			
			listModel.addElement(file);
		}
		this.activeQuests.setModel(listModel);
	}
	
	public JList getFinishedQuests() {
		return finishedQuests;
	}
	public void setFinishedQuests(WraithFile[] wraithFiles) {
		DefaultListModel listModel = new DefaultListModel();
		for (WraithFile file : wraithFiles) {
			listModel.addElement(file);
		}
		this.finishedQuests.setModel(listModel);
	}
}
