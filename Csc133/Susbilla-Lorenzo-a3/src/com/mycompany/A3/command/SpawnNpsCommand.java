package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;

//spawn Nps command
public class SpawnNpsCommand extends Command {
	private GameWorld gw;
	
	public SpawnNpsCommand(GameWorld gw) {
		super("Spawn NonPlayership");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		gw.SpawnNonPlayerShip();
	}
}
