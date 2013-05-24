package net.teamwraith.wraithquest;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import net.teamwraith.wraithquest.files.FileReader;
import net.teamwraith.wraithquest.files.QuestReader;
import net.teamwraith.wraithquest.files.link.Task;

public class WraithQuest {
	
	static InputStreamReader istream = new InputStreamReader(System.in) ;
    static BufferedReader bufRead = new BufferedReader(istream) ;
	
   
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GUIBuild();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
