package com.mycompany.A3.interfacer;

import com.mycompany.A3.GameCollection;

public interface IGameWorld {
	int getPlayerScore();
	int getPlayerLives();
	int getAsteroidCount();
	int getNPSCount();
	int getMissileCounter();
	int getGameTick();
	GameCollection getGameCollection();
}
