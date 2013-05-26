package net.teamwraith.wraithquest.files.link;


public class Quest extends WraithFile {

//	Current task. 0: Quest isn't initialised. Will increment for each step.
	private int 		currentTask = 0;
	
	public int getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(int currentTask) {
		this.currentTask = currentTask;
	}

}
