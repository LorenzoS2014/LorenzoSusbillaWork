package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class ChangeDirectionRightCommand extends Command {
	private GameWorld gw;
	public ChangeDirectionRightCommand(GameWorld gw) {
		super("Change Player Direction Right");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed( ActionEvent e ) {
		gw.ChangePlayerShipDirection(10);
	}
}
