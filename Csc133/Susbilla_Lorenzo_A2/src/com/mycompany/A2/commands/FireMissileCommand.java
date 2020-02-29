package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class FireMissileCommand extends Command {
	private GameWorld gw;
	
	public FireMissileCommand(GameWorld gw) {
		super("Enemy Fire!");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		gw.fireMissile();
	}	
}
