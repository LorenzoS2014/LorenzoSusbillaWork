package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class PlayerCrashAsteroidCommand extends Command {
	private GameWorld gw;
	public PlayerCrashAsteroidCommand(GameWorld gw) {
		super("Player Crash into Asteroid");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		if (gw.getAsteroidCount() == 0 && gw.checkPlayerShip() == false) {
			System.out.println("No asteroids or player ship");
		} else if (gw.getAsteroidCount() == 0) {
			System.out.println("no asteroids");
		} else if (gw.checkPlayerShip() == false) {
			System.out.println("no Player Ship");
		} else {
			gw.DestroyPlayerShip();
			gw.DestroyAsteroid();
		}
	}
}
