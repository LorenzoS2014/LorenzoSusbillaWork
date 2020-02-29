package com.mycompany.A2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A2.GameWorld;

public class PlayerMissileDestroyCommand extends Command {
	private GameWorld gw;
	
	public PlayerMissileDestroyCommand(GameWorld gw) {
		super("Player Destroyed by Missile");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		if (gw.checkPlayerShip() == false && gw.getMissileCounter() == 0) {
			System.out.println("No Player Ship or missile ");
		} else if (gw.checkPlayerShip() == false) {
			System.out.println("No Player Ship");
		} else if (gw.getMissileCounter() == 0) {
			System.out.println("no missiles");
		} else {
			gw.DestroyPlayerShip();
			gw.DestroyMissile();
		}
	}
}
