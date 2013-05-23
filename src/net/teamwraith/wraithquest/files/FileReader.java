package net.teamwraith.wraithquest.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.teamwraith.wraithquest.files.WraithFile.FileType;
import net.teamwraith.wraithquest.files.WraithFile.State;
import net.teamwraith.wraithquest.files.link.Character;
import net.teamwraith.wraithquest.files.link.Cutscene;
import net.teamwraith.wraithquest.files.link.Quest;
import net.teamwraith.wraithquest.files.link.Task;


public class FileReader {

	private static Scanner reader;
	
	public static File[] getFileArray() {
		String		path = "./quests",
					filePath;
		List<File> 	questFiles = new ArrayList<File>();
		File 		folder = new File (path);
		File[] 		listOfFiles = folder.listFiles();
	 
		for (File file : listOfFiles) {
			if (file.isFile())
			{
				filePath = file.getPath();
				if (filePath.endsWith(".wq")) //WraithQuest
				{
					questFiles.add(file);
				}
			}
		}
		return questFiles.toArray(new File[questFiles.size()]);
	}
	
	public static WraithFile[] getWraithFileArray() {
		List<WraithFile> 	wraithFiles = new ArrayList<WraithFile>();
		for (File file : getFileArray()) {
			wraithFiles.add(readFile(file));
		}
		return wraithFiles.toArray(new WraithFile[wraithFiles.size()]);
	}
	
	public static WraithFile[] getWraithFileArray(FileType type) {
		List<WraithFile> 	wraithFiles = new ArrayList<WraithFile>();
		for (WraithFile file : getWraithFileArray()) {
			if (file.getFileType() == type) {
				wraithFiles.add(file);
			}
		}
		return wraithFiles.toArray(new WraithFile[wraithFiles.size()]);
	}
	
	public static WraithFile[] getWraithFileArray(State state) {
		List<WraithFile> 	wraithFiles = new ArrayList<WraithFile>();
		for (WraithFile file : getWraithFileArray()) {
			if (file.getState() == state)
				wraithFiles.add(file);
		}
		return wraithFiles.toArray(new WraithFile[wraithFiles.size()]);
	}
	
	public static WraithFile[] getWraithFileArray(State state, FileType type) {
		List<WraithFile> 	wraithFiles = new ArrayList<WraithFile>();
		for (WraithFile file : getWraithFileArray(type)) {
			if (file.getState() == state)
				wraithFiles.add(file);
		}
		return wraithFiles.toArray(new WraithFile[wraithFiles.size()]);
	}

	
	public static WraithFile readFile(File file) {
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File @ error: "+file.getName() + " @ path "+file.getAbsolutePath() + "\n");
			e.printStackTrace(); // TODO Later, print an error in the gui so the user knows what to report.
		}
		while (reader.hasNext()) {
			String line = reader.nextLine();
			if (line.startsWith("type=")) {
				if 		(line.contains("cutscene")) { return readCutscene(new Cutscene()); }
				else if (line.contains("character")){ return readCharacter(new Character()); }
				else { return readQuest(new Quest()); }
			}
		}
		return readQuest(new Quest());
		
	}


	private static Quest readQuest(Quest object) {
		
		boolean taskPoints = false;
		List<Task> tasks = new ArrayList<Task>();
		object.setFileType(FileType.QUEST);
		//TODO Add a check to see if this quest Object already exist.
		
		while (reader.hasNext()) {
			String line = reader.nextLine();
			
			//TODO Add a Statecheck (add to filesyntax "state=").
			if (line.startsWith("state=")) {
				object.setState(State.fromString(line.substring(6).toLowerCase()));
			}
			
			if (line.startsWith("name=")){
				object.setName(line.substring(5));
			}

			if (line.startsWith("description=")){
				String description = line.substring(12);
				// Parsing paragraphs.
				description = description.replaceAll("<p>", "\r\n\r\n");
				description = description.replaceAll("<br>", "\r\n");
				description = description.replaceAll("<t>", "\t");
				object.setDescription(description);
			}
			
			if (line.startsWith("tasks={")) {
				taskPoints = true;
				continue;
			}
		
			if (line.startsWith("}") && taskPoints){
				taskPoints = false;
				object.setTasks(tasks.toArray(new Task[tasks.size()]));
			}

			if (taskPoints){
				String[] params = line.split("#");
				if (params.length < 3) {
					try {
						throw new Exception("The objective: '" + object.getName() + "' had a taskpoint-line containing " +
								"less parameters than needed");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (params.length == 3) { tasks.add(new Task(params[0],params[1],State.fromString(params[2]))); }
				else { tasks.add(new Task(params[0],params[1],params[2],State.fromString(params[3]))); }
			}
		}
		return object;
	}

	private static Cutscene readCutscene(Cutscene object) {
		object.setFileType(FileType.CUTSCENE);
		while (reader.hasNext()) {
			String line = reader.nextLine();
			
			if (line.startsWith("state=")) {
				object.setState(State.fromString(line.substring(6).toLowerCase()));
			}
			
			if (line.startsWith("name=")){
				object.setName(line.substring(5));
			}
			
			if (line.startsWith("link=")){
				object.setVideoLink(line.substring(5));
			}
			
			if (line.startsWith("password=")){
				object.setPassword(line.substring(9));
			}
		}
		object.setTasks(new Task[] {
				new Task(object.getVideoLink(), object.getName(), object.getPassword(), object.getState()) 
				});
		
		return object;
	}

	private static Character readCharacter(Character object) {
		object.setFileType(FileType.CHARACTER);
		boolean hasMoreLinks = false;
		List<Task> links = new ArrayList<Task>();
		
		while (reader.hasNext()) {
			String line = reader.nextLine();
			int sceneNr = 0;
			if (line.startsWith("state=")) {
				object.setState(State.fromString(line.substring(6).toLowerCase()));
			}
			
			if (line.startsWith("name=")){
				object.setName(line.substring(5));
			}
			
			if (line.startsWith("links={")) {
				hasMoreLinks = true;
				continue;
			}
		
			if (line.startsWith("password=")){
				object.setPassword(line.substring(9));
			}
			
			if (line.startsWith("}") && hasMoreLinks){
				hasMoreLinks = false;
				object.setTasks(links.toArray(new Task[links.size()]));
			}

			if (hasMoreLinks){
				sceneNr++;
				String[] params = line.split("#");
				if (params.length < 1) {
					try {
						throw new Exception("The objective: '" + object.getName() + "' had a taskpoint-line containing " +
								"less parameters than needed");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				links.add(new Task(object, sceneNr, params[0],State.fromString(params[1]))); }
			}
		return object;
	}
}
