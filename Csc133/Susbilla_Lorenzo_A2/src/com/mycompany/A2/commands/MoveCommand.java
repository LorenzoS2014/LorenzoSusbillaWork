package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

//move command class
public class MoveCommand extends Command {
	private GameWorld gw;
	public MoveCommand(GameWorld gw) {
		super("Move");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed( ActionEvent e ) {
		gw.Move();
		System.out.println("Move successful");
	}
}