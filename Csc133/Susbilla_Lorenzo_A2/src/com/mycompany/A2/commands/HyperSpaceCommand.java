package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class HyperSpaceCommand extends Command {
	private GameWorld gw;
	
	public HyperSpaceCommand(GameWorld gw) {
		super("Hyper Space!");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		gw.HyperSpaceJump();
	}
}
