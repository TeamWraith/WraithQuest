package net.teamwraith.wraithquest.files;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.teamwraith.wraithquest.files.WraithFile.FileType;
import net.teamwraith.wraithquest.files.WraithFile.State;
import net.teamwraith.wraithquest.files.link.Task;


public class QuestReader {

	

	public static Task[] getTaskArray(WraithFile questObject) {
		if (questObject.getFileType() == FileType.CUTSCENE) {
			return new Task[] {questObject.getTasks()[0]};
		}
		else return questObject.getTasks();
	}
	
	public static Task[] getPasswordMatches(String pass) {
		List<Task> taskMatches = new ArrayList<Task>();
		for (WraithFile file : FileReader.getWraithFileArray()) {
			for (Task task : getTaskArray(file)) {
				
				if (file.getState() != State.DISABLED) {
					
					if (task.getPassword().equals(pass) &&
						task.getState() != State.DISABLED) {
						taskMatches.add(task);
					}
					
				}
			}
		}
		System.out.println("Tasks that matched: " + taskMatches);
		
		return taskMatches.toArray(new Task[taskMatches.size()]);
	}
}