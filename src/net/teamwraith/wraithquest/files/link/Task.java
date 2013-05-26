package net.teamwraith.wraithquest.files.link;

public class Task extends Cutscene {
	
	private WraithFile parent;
// 	The text of the task point
	private int sceneNr;

	private String taskPoint = "null task"; 

	@Override
	public String toString() {
		return taskPoint;
	}
	
	public WraithFile getParent() {
		return parent;
	}

	public void setParent(WraithFile parent) {
		this.parent = parent;
	}
	
	public int getSceneNr() {
		return sceneNr;
	}

	public void setSceneNr(int sceneNr) {
		this.sceneNr = sceneNr;
	}
	
	public String getTaskPoint() {
		return taskPoint;
	}

	public void setTaskPoint(String taskPoint) {
		this.taskPoint = taskPoint;
	}

	/**
	 * Constructor for object Task.
	 * 
	 * @param parent - The parent/quest/object of this task
	 * @param taskPoint - String representing the text that will show up under task points.
	 * @param password - the password.
	 * @param taskState - The state this task will be set to.
	 */
	public Task(WraithFile parent, String taskPoint, String password, State taskState) {
		setParent(parent);
		setTaskPoint(taskPoint);
		setPassword(password);
		setState(taskState);
	}
	
	/**
	 * Constructor for object Task.
	 * 
	 * @param parent - The parent/quest/object of this task
	 * @param videoLink - Link to the youtube video that will play. Not required.
	 * @param taskPoint - String representing the text that will show up under task points.
	 * @param password - The password.
	 * @param taskState - The state this task will be set to.
	 */
	public Task(WraithFile parent, String videoLink, String taskPoint, String password, State taskState) {
		this(parent, taskPoint, password, taskState);
		setParent(parent);
		setVideoLink(videoLink);
	}
	
	/**
	 * Constructor for object Task (Used when the parent object is of the type Character).
	 * 
	 * @param parent - The parent/quest/object of this task
	 * @param sceneNr - The indicator number of this scene.
	 * @param link - The videolink.
	 */
	public Task(Character parent,int sceneNr, String link, State taskState) {
		setParent(parent);
		setSceneNr(sceneNr);
		setVideoLink(link);
		setTaskPoint(parent.getName() + " - " + sceneNr);
		setState(taskState);
		setPassword(parent.getPassword());
	}

}
