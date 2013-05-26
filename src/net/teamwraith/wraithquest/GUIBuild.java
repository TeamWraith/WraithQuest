package net.teamwraith.wraithquest;

import net.teamwraith.wraithquest.gui.main.MainFrame;

/**
 * Builds the GUI.
 */
public class GUIBuild {
	
	//main window
	private static final MainFrame mainFrame = new MainFrame();

	public GUIBuild(){
		//TODO Have the project/program(etc. "Minecraft") name in these parameters.
	}
	
	public static MainFrame getMainFrame() {
		return mainFrame;
	}
}
