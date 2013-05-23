package net.teamwraith.wraithquest;

import net.teamwraith.wraithquest.gui.main.MainFrame;

/**
 * Builds the GUI.
 */
public class GUIBuild {
	
	//main window
	private MainFrame mainFrame;

	public GUIBuild(){
		mainFrame = new MainFrame();
	}
		public MainFrame getMainFrame() { return mainFrame; }
}
