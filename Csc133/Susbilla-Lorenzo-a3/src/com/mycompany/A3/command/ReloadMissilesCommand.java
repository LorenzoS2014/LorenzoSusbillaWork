package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;

public class ReloadMissilesCommand extends Command {
	private GameWorld gw;
	public ReloadMissilesCommand(GameWorld gw) {
		super("Reload Missiles");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		gw.AddSupply();
	}

}
