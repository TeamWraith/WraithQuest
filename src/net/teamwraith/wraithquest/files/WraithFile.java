package net.teamwraith.wraithquest.files;

import net.teamwraith.wraithquest.files.link.Task;

public class WraithFile {

	/**
	 * The different states quests/objects and tasks/events can be set to have.<p>
	 * 
	 * <b>DISABLED</b> - Used when the objective is not supposed to be able to activate yet.<br>
	 * <b>NOT_STARTED</b> - Used when the objective is able to be activated, but not yet started.<br>
	 * <b>STARTED</b> - Used when the objective is active and started.<br>
	 * <b>FAILED</b> - Used when the objective is failed to complete.<br>
	 * <b>COMPLETED</b> - Used when the objective is completed with success.
	 * 
	 * @author Stektpotet
	 */
	public static enum State {
		 DISABLED ("disabled"), 
		 NOT_STARTED ("not started"), 
		 STARTED ("started"), 
		 FAILED ("failed"), 
		 COMPLETED ("completed");

		 private final String stateName;
		 
		 State(String stateName) {
			 this.stateName = stateName;
		 }
		 
		 @Override
		 public String toString() {
			 return stateName;
		 }
		 
		 public static State fromString(String stateName) {
		        for (State s : values() ){
		            if (s.stateName.equals(stateName)) return s;
		        }
		        return State.DISABLED;
		    }
	}
	
	public static enum FileType {
		QUEST, CUTSCENE, CHARACTER
	}
	private State 	state = State.NOT_STARTED;
	private FileType	type = FileType.QUEST;
	
//	Array of tasks that the quest will undergo.
	private Task[] 		tasks=null;
	
	/**
	 * @Notice!
	 * <b>password</b> - Should only be used for 
	 * 
	 */
	private String 	name =null,
					description=null,
					password=null,
					additDesc=null;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public FileType getFileType() {
		return type;
	}

	public void setFileType(FileType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Task[] getTasks() {
		return tasks;
	}

	public void setTasks(Task[] tasks) {
		this.tasks = tasks;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdditDesc() {
		return additDesc;
	}

	public void setAdditDesc(String additDesc) {
		this.additDesc = additDesc;
	}
}
