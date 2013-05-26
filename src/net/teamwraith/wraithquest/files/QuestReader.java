package net.teamwraith.wraithquest.files;

import java.util.ArrayList;
import java.util.List;

import net.teamwraith.wraithquest.files.link.Task;
import net.teamwraith.wraithquest.files.link.WraithFile;
import net.teamwraith.wraithquest.files.link.WraithFile.State;

public class QuestReader {

	
	/**
	 * @param questObject - The object in which the tasks are.
	 * @return An array of all tasks the object holds
	 */
	public static Task[] getTaskArray(WraithFile questObject) {
		return questObject.getTasks();
	}
	
	/**
	 * 
	 * @param questObject - The object in which the tasks are.
	 * @param taskstate - Makes the method search only for the tasks with theese specific states.
	 * @return An array of tasks with the specific state
	 */
	public static Task[] getTaskArray(WraithFile questObject, State... taskstate) {
		List<Task> taskMatches = new ArrayList<Task>();
		
		for (Task task : questObject.getTasks()) {
			for (State state : taskstate) {
				if (task.getState() == state) {
					taskMatches.add(task);
				}
			}
		}
		return taskMatches.toArray(new Task[taskMatches.size()]);
	}
	
	/**
	 * @param pass - The password the program should look for matching Tasks with.
	 * @return An array of tasks in which the password matches.
	 */
	public static Task[] getPasswordMatches(String pass) {
		List<Task> taskMatches = new ArrayList<Task>();
		for (WraithFile file : FileReader.getWraithFileArray()) {
			for (Task task : getTaskArray(file)) {
				if (task.getPassword().equals(pass) && task.getState() != State.DISABLED) {
					taskMatches.add(task);
				}
			}
		}
		System.out.println("Tasks that matched: " + taskMatches);
		
		return taskMatches.toArray(new Task[taskMatches.size()]);
	}
}