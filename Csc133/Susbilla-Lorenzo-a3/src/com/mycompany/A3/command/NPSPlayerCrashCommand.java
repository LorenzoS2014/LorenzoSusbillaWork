package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;

public class NPSPlayerCrashCommand extends Command {
	private GameWorld gw;
	
	public NPSPlayerCrashCommand(GameWorld gw) {
		super("NonPlayer crash into Player");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		if (gw.checkPlayerShip() == false && gw.getNPSCount() == 0) {
			System.out.println("No Player Ship or missile ");
		} else if (gw.checkPlayerShip() == false) {
			System.out.println("No Player Ship");
		} else if (gw.getNPSCount() == 0) {
			System.out.println("no ship");
		} else {
			gw.DestroyPlayerShip();
			gw.DestroyNonPlayerShip();
		}
	}
}
