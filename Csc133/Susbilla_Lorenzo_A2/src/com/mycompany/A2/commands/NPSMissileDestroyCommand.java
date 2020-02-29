package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class NPSMissileDestroyCommand extends Command {
	private GameWorld gw;
	
	public NPSMissileDestroyCommand(GameWorld gw) {
		super("NonPlayer Destroyed by Missile");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		if (gw.getNPSCount() == 0 && gw.getMissileCounter() == 0) {
			System.out.println("No Ship or missile ");
		} else if (gw.getNPSCount() == 0) {
			System.out.println("No Ship");
		} else if (gw.getMissileCounter() == 0) {
			System.out.println("no missiles");
		} else {
			gw.DestroyNonPlayerShip();
			gw.DestroyMissile();
		}
	}
}
