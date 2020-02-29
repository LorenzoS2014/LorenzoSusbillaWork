package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class NPSAsteroidCrashCommand extends Command {
	private GameWorld gw;
	
	public NPSAsteroidCrashCommand(GameWorld gw) {
		super("NonPlayer crash into Asteroid");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		if (gw.getAsteroidCount() == 0 && gw.getNPSCount() == 0) {
			System.out.println("No Asteroid or ships");
		} else if (gw.getAsteroidCount() == 0) {
			System.out.println("No Asteroid");
		} else if (gw.getNPSCount() == 0) {
			System.out.println("no Ship");
		} else {
			gw.DestroyAsteroid();
			gw.DestroyNonPlayerShip();
		}
	}
}
