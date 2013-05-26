package net.teamwraith.wraithquest.gui.main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.teamwraith.wraithquest.files.link.WraithFile;

@SuppressWarnings("serial")
public class ListPanel extends JPanel{
	
	private JList<WraithFile> 
		activeQuests = new JList<WraithFile>(), 
		finishedQuests = new JList<WraithFile>();

	private JScrollPane 
		activeQuestsPane = new JScrollPane(
		activeQuests,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
			
		finishedQuestsPane = new JScrollPane(
		finishedQuests,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	private final GridBagConstraints gbc = new GridBagConstraints();
	
	public ListPanel() {
		setLayout(new GridBagLayout());
		
		activeQuestsPane.setPreferredSize(new Dimension(250, 300));
		finishedQuestsPane.setPreferredSize(new Dimension(250, 120));
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 0;
		add(new JLabel("Active quests:"), gbc);
		gbc.gridy=1;
		gbc.weighty = 1;
		add(activeQuestsPane, gbc);
		gbc.gridy=2;
		gbc.weighty = 0;
		add(new JLabel("Finished quests:"), gbc);
		gbc.gridy=3;
		add(finishedQuestsPane, gbc);
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

