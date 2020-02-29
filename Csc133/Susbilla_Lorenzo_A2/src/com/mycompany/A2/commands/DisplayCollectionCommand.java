package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class DisplayCollectionCommand extends Command {
	private GameWorld gw;
	public DisplayCollectionCommand(GameWorld gw) {
		super("Display Objects");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed( ActionEvent e ) {
		gw.displayCollection();
	}
}
