package net.teamwraith.wraithquest.files.link;
import net.teamwraith.wraithquest.files.WraithFile;

public class Task extends Cutscene {

// 	The text of the task point
	private String taskPoint = "null task"; 

	public String getTaskPoint() {
		return taskPoint;
	}

	public void setTaskPoint(String taskPoint) {
		this.taskPoint = taskPoint;
	}

	/**
	 * Constructor for object Task.
	 * 
	 * @param taskPoint - String representing the text that will show up under task points.
	 * @param password - the password.
	 * @param taskState - The state this task will be set to.
	 */
	public Task(String taskPoint, String password, State taskState) {
		setTaskPoint(taskPoint);
		setPassword(password);
		setState(taskState);
	}
	
	/**
	 * Constructor for object Task.
	 * 
	 * @param videoLink - Link to the youtube video that will play. Not required.
	 * @param taskPoint - String representing the text that will show up under task points.
	 * @param password - The password.
	 * @param taskState - The state this task will be set to.
	 */
	public Task(String videoLink, String taskPoint, String password, State taskState) {
		this(taskPoint, password, taskState);
		setVideoLink(videoLink);
	}
	
	/**
	 * Constructor for object Task (Used when the parent object is of the type Character).
	 * 
	 * @param character - The parrent of this scene.
	 * @param sceneNr - The indicator number of this scene.
	 * @param link - The videolink.
	 */
	public Task(WraithFile character,int sceneNr, String link, State taskState) {
		setVideoLink(link);
		setTaskPoint(character.getName() + sceneNr);
		setState(taskState);
	}
	
}
