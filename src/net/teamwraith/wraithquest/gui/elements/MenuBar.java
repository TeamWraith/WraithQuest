package net.teamwraith.wraithquest.gui.elements;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

//TODO make user able to edit the dialogue name later on from a menuitem.
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	
	private JMenu 
		file = new JMenu("File"),
		help = new JMenu("Help");
	
	// File menu
	private JMenuItem newDialogue =  new JMenuItem("New Dialogue"); 
	private JMenuItem newNode = new JMenuItem("New Node");
	
	private JMenuItem refresh =  new JMenuItem("Refresh");
	private JMenuItem saveDialogue = new JMenuItem("Save Dialogue");
	
	private JMenuItem exit =  new JMenuItem("Exit"); 
	
	// Help menu
	private JMenuItem about = new JMenuItem("About WraithQuest");
	
	public MenuBar() {
		newNode.setEnabled(false);
		saveDialogue.setEnabled(false);
		
		add(file);
		file.add(newDialogue);
		file.add(newNode);
		file.add(new MenuSeparator(Color.LIGHT_GRAY));
		file.add(refresh);
		file.add(saveDialogue);
		file.add(new MenuSeparator(Color.LIGHT_GRAY));
		file.add(exit);
		add(help);
		help.add(about);
	}
	
	public JMenuItem getNewDialogue() { return newDialogue; }

	public JMenuItem getNewNode() { return newNode; }
	
	public JMenuItem getRefresh() { return refresh; }
	
	public JMenuItem getSaveDialogue() { return saveDialogue; }
	
	public JMenuItem getExit() { return exit; }
	
	public JMenuItem getAbout() { return about; }
	
	public class MenuSeparator extends JSeparator {
		
		public MenuSeparator(Color color) {
			setForeground(color);
		}
		
	}
	
}


