package net.teamwraith.wraithquest.gui.main;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.teamwraith.wraithquest.files.WraithFile;

public class ListPanel extends JPanel{

	private JScrollPane activeQuestsPane = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
			
			finishedQuestsPane = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	private JList<WraithFile> 	activeQuests = new JList<WraithFile>(), 
					finishedQuests = new JList<WraithFile>();
	
	/**
	 * 
	 */
	public ListPanel() {
		setLayout(new BorderLayout());
		add(activeQuestsPane, BorderLayout.CENTER);
		add(finishedQuestsPane, BorderLayout.SOUTH);
		activeQuestsPane.setViewportView(activeQuests);
		finishedQuestsPane.setViewportView(this.finishedQuests);
		
	}
	
	public JList<WraithFile> getActiveQuests() {
		return activeQuests;
	}
	
	public void setActiveQuests(WraithFile[] wraithFiles) {
		DefaultListModel<WraithFile> listModel = new DefaultListModel<WraithFile>();
		
		for (WraithFile file : wraithFiles) {
	
			listModel.addElement(file);
		}
		activeQuests.setModel(listModel);
	}
	
	public JList<WraithFile> getFinishedQuests() {
		return finishedQuests;
	}
	public void setFinishedQuests(WraithFile[] wraithFiles) {
		DefaultListModel<WraithFile> listModel = new DefaultListModel<WraithFile>();
		for (WraithFile file : wraithFiles) {
			listModel.addElement(file);
		}
		this.finishedQuests.setModel(listModel);
	}
}
