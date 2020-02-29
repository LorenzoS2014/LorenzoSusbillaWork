package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;

public class DecreaseSpeedCommand extends Command {
	private GameWorld gw;
	public DecreaseSpeedCommand(GameWorld gw) {
		super("Decrease Speed");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed( ActionEvent e ) {
		gw.DecreasePlayerSpeed();
	}
}
