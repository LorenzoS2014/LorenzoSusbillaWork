package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class SpawnPlayerShipCommand extends Command {

	private GameWorld gw;
	public SpawnPlayerShipCommand(GameWorld gw) {
		super("Spawn Playership");
		this.gw = gw;
	}
	public void actionPerformed( ActionEvent e ) {
		gw.SpawnPlayerShip();
	}
}
