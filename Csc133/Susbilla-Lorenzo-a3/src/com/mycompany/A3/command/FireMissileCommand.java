package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;
import com.mycompany.A3.Sound;

public class FireMissileCommand extends Command {
	private GameWorld gw;
	private Sound fireMissileSound;
	public FireMissileCommand(GameWorld gw) {
		super("Enemy Fire!");
		this.gw = gw;
		fireMissileSound = new Sound("Space-Cannon.mp3");
	}
	public void actionPerformed (ActionEvent e) {
		if (!gw.getSoundFlag()) {
			fireMissileSound.play();
		} else {
			if(!gw.getSoundFlag()) {
				fireMissileSound.play();
			}
			gw.fireMissile();
		}
	}	
}
