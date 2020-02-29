package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;

public class PauseCommand extends Command  {
	GameWorld gw;
	public PauseCommand(GameWorld gw) {
		super("Pause");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		gw.setPauseFlag();
	}
}
