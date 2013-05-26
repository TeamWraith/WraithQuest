package net.teamwraith.wraithquest.gui.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.teamwraith.wraithquest.files.FileReader;
import net.teamwraith.wraithquest.files.link.WraithFile.FileType;
import net.teamwraith.wraithquest.files.link.WraithFile.State;
import net.teamwraith.wraithquest.gui.elements.MenuBar;

/**
 * @author Halvor
 *
 */
public class MainFrame extends JFrame {

	private final String project = "Minecraft";
	final Dimension display = new Dimension(
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth(),
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()
			);
	
	private static final ListPanel listPanel = new ListPanel();
	private static final QuestPanel questPanel = new QuestPanel();
	
	/**
	 * @param args
	 */
	public MainFrame() {
		init();
		getContentPane().add(listPanel, BorderLayout.WEST);
		getContentPane().add(questPanel, BorderLayout.CENTER);
		setListPanelActive();
		setListPanelFinished();
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
//TODO Move somewhere else and make it dyamically update when a quest is activated.
	public void setListPanelActive() {
		listPanel.setActiveQuests(FileReader.getWraithFileArray(State.STARTED, FileType.QUEST));
	}
	public void setListPanelFinished() {
		listPanel.setFinishedQuests(
				FileReader.getFilledWraithFileArray(FileType.QUEST, State.FAILED, State.COMPLETED));
	}


	public static ListPanel getListPanel() {
		return listPanel;
	}

	public static QuestPanel getQuestPanel() {
		return questPanel;
	}
}
