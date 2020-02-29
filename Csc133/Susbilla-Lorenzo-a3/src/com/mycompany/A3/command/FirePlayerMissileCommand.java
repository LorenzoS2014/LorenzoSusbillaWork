package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;
import com.mycompany.A3.Sound;

public class FirePlayerMissileCommand extends Command {
	private GameWorld gw;
	private Sound fireMissileSound;
	public FirePlayerMissileCommand(GameWorld gw) {
		super("Fire!");
		this.gw = gw;
		fireMissileSound = new Sound("Space-Cannon.mp3");
	}
	public void actionPerformed (ActionEvent e) {
		fireMissileSound.play();
		gw.firePlayerMissile();
	}
}
