package com.mycompany.A3;

import java.util.Observable;

import com.mycompany.A3.interfacer.IGameWorld;

public class GameWorldProxy extends Observable implements IGameWorld {
	
	private GameWorld gw;
	public GameWorldProxy (GameWorld gw) {
		this.gw = gw;
	}
	public int getPlayerScore() {
		return gw.getPlayerScore();
	}
	@Override
	public int getPlayerLives() {
		return gw.getPlayerLives();
	}
	@Override
	public int getAsteroidCount() {
		// TODO Auto-generated method stub
		return gw.getAsteroidCount();
	}
	@Override
	public int getNPSCount() {
		// TODO Auto-generated method stub
		return gw.getNPSCount();
	}
	@Override
	public int getMissileCounter() {
		// TODO Auto-generated method stub
		return gw.getMissileCounter();
	}
	@Override
	public int getGameTick() {
		return gw.getGameTick();
	}
	@Override
	public GameCollection getGameCollection() {
		return gw.getGameCollection();
	}


}
