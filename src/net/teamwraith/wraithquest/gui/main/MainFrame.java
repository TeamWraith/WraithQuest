package net.teamwraith.wraithquest.gui.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.teamwraith.wraithquest.files.FileReader;
import net.teamwraith.wraithquest.files.WraithFile.FileType;
import net.teamwraith.wraithquest.files.WraithFile.State;
import net.teamwraith.wraithquest.gui.elements.MenuBar;

public class MainFrame extends JFrame {

	private final String project = "Minecraft";
	final Dimension display = new Dimension(
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth(),
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()
			);
	
	private ListPanel listPanel = new ListPanel();
	private QuestPanel questPanel = new QuestPanel();
	
	/**
	 * @param args
	 */
	public MainFrame() {
		init();
		getContentPane().add(listPanel, BorderLayout.WEST);
		getContentPane().add(questPanel, BorderLayout.CENTER);
		setListPanelActive();
	}

	private void init() {
		JPanel contentPane = new JPanel();
		setTitle("Wraith Questing - " + project);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(display.width/2 - 256, display.height/2 - 320, 535, 600);
		setMinimumSize(new Dimension(535, 600));
		setContentPane(contentPane);
		setJMenuBar(new MenuBar());
		contentPane.setLayout(new BorderLayout());
		setVisible(true);
	}

	public void setListPanelActive() {
		this.listPanel.setActiveQuests(FileReader.getWraithFileArray(State.STARTED, FileType.QUEST));
	}
	public void setListPanelFinished(ListPanel listPanel) {
		this.listPanel.setFinishedQuests(FileReader.getWraithFileArray(State.COMPLETED, FileType.QUEST));
	}


}
