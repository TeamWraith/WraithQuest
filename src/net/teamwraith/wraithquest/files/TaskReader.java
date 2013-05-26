package net.teamwraith.wraithquest.files;

import net.teamwraith.wraithquest.GUIBuild;
import net.teamwraith.wraithquest.files.link.Quest;
import net.teamwraith.wraithquest.files.link.Task;
import net.teamwraith.wraithquest.files.link.WraithFile.FileType;
import net.teamwraith.wraithquest.gui.main.MainFrame;
import net.teamwraith.wraithquest.gui.main.QuestPanel;

public class TaskReader {

	public static void openLink (String link) {
		System.out.println(link);
	}
	
	public static void openRelated(Task task) {
		if (task.getParent().getFileType() == FileType.QUEST) {openRelatedQuest(task);}
	}

	private static void openRelatedQuest(Task task) {
		GUIBuild.getMainFrame();
		QuestPanel qp = MainFrame.getQuestPanel();
		Quest object = (Quest) task.getParent();
		
		qp.setLink(task.getVideoLink());
		qp.setQuestDescription(object.getDescription());
		qp.setTasks(object.getTasks());
		
	}
	
}
