package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class IncreaseSpeedCommand extends Command {
	private GameWorld gw;
	public IncreaseSpeedCommand(GameWorld gw) {
		super("Increase Speed");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed( ActionEvent e ) {
		gw.IncreasePlayerSpeed();
	}
}
