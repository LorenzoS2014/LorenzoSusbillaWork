package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class AsteroidMissileDestroyCommand extends Command {
	private GameWorld gw;
	
	public AsteroidMissileDestroyCommand(GameWorld gw) {
		super("Asteroid Destroyed by Missile");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		if (gw.getAsteroidCount() == 0 && gw.getMissileCounter() == 0) {
			System.out.println("No Asteroid or missile ");
		} else if (gw.getAsteroidCount() == 0) {
			System.out.println("No Asteroid");
		} else if (gw.getMissileCounter() == 0) {
			System.out.println("no missiles");
		} else {
			gw.DestroyAsteroid();
			gw.DestroyMissile();
		}
	}
}
