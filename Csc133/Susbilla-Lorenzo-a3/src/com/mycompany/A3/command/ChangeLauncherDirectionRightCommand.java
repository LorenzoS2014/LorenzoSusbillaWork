package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;

public class ChangeLauncherDirectionRightCommand extends Command {
	private GameWorld gw;
	
	public ChangeLauncherDirectionRightCommand(GameWorld gw) {
		super("Change Launcher Direction Right");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		gw.ChangePlayerShipLauncherDirection(10);
	}
}
