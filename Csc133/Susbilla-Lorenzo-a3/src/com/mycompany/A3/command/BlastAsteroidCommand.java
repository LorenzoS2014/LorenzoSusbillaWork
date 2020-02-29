package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;
import com.mycompany.A3.Sound;

public class BlastAsteroidCommand extends Command {
		private GameWorld gw;
		private Sound blastAsteroidSound;
	public BlastAsteroidCommand(GameWorld gw) {
		super("Blast Asteroid");
		this.gw = gw;
		blastAsteroidSound = new Sound("Space_Alert1.mp3");
	}
	public void actionPerformed (ActionEvent e) {
		if (gw.getAsteroidCount() == 0 && gw.getMissileCounter() == 0) {
			System.out.println("No Asteroid or missile ");
		} else if (gw.getAsteroidCount() == 0) {
			System.out.println("No Asteroid");
		} else if (gw.getMissileCounter() == 0) {
			System.out.println("no missiles");
		} else {
			if(!gw.getSoundFlag()) {
				blastAsteroidSound.play();
			}
			gw.DestroyAsteroid();
			gw.DestroyMissile();
		}
	}

}
