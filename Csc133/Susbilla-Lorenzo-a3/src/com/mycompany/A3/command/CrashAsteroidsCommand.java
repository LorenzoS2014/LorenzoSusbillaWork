package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;

public class CrashAsteroidsCommand extends Command {
	private GameWorld gw;
	
	public CrashAsteroidsCommand(GameWorld gw) {
		super("Crash Asteroids");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		if (gw.getAsteroidCount() < 2) {
			System.out.println("not enough asteroids to destroy");
		} else {
			gw.DestroyAsteroid();
			gw.DestroyAsteroid();
		}
	}
}
