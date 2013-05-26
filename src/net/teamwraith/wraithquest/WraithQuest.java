package net.teamwraith.wraithquest;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WraithQuest {
	
	static InputStreamReader istream = new InputStreamReader(System.in);
    static BufferedReader bufRead = new BufferedReader(istream);
    
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
