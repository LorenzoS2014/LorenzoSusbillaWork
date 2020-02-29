package com.mycompany.A3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.mycompany.A3.Sound;

import com.mycompany.A3.interfacer.IGameWorld;
import com.mycompany.A3.interfacer.IIterator;
import com.mycompany.A3.interfacer.IMoveable;
//GameWorld holds and instantiates all of the objects and stores them
public class GameWorld extends Observable implements IGameWorld{
	private Random random = new Random();
	private GameCollection theGameCollection = new GameCollection();
	private boolean soundFlag = false;
	private boolean pauseFlag = false;
	private int asteroidCounter;
	private int nPSCounter;
	private int missileCounter;
	private boolean playerShipSpawned = false; 
	private boolean spaceStationSpawned = false;
	private int playerLives = 3;
	private int playerScore;
	private int gameTick;
	private Sound loseSound = new Sound("Explosion2.mp3");
	public boolean getPauseFlag() {
		return pauseFlag;
	}
	public void setPauseFlag() {
		pauseFlag = !pauseFlag;
	}
	public boolean getSoundFlag() {
		return soundFlag;
	}
	public void setSoundflag() {
		soundFlag = !soundFlag;
	}
	public void SpawnPlayerShip() { //Spawns Player Ship
		if (playerShipSpawned == false) {
			PlayerShip playerShip = new PlayerShip(1, 0, 660, 660, 255,0, 0,100);
			if (playerLives == 3) {
				System.out.println("PlayerShip spawned");
			} else System.out.println("New Player Ship Spawned");
			theGameCollection.add(playerShip);
			//theGameCollection.add(playerShip.playerMissileLauncher);
			playerShipSpawned = true;
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		} else { 
			System.out.println("PlayerShip already spawned");
		}
	}
	public void SpawnAsteroid() { //Spawns Asteroid
		Asteroid asteroid = new Asteroid(random.nextInt(1025), random.nextInt(786), 
											1 + random.nextInt(10), random.nextInt(361), 0, 255, 0,0);
		theGameCollection.add(asteroid);
		asteroidCounter++;
		System.out.println("Asteriod number " + asteroidCounter + " spawned");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void SpawnNonPlayerShip() { //Spawns NPS
		NonPlayerShip nonPlayerShip = new NonPlayerShip(5 + random.nextInt(6), random.nextInt(361),random.nextInt(1025), 
															random.nextInt(786), 255, 0,0, 50 + (random.nextInt(2) * 50));
		theGameCollection.add(nonPlayerShip);
		//theGameCollection.add(nonPlayerShip.missileLauncher);
		nPSCounter++;
		System.out.println("NPS " + nPSCounter + " spawned");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public int getAsteroidCount() {
		return asteroidCounter;
	}
	public int getNPSCount() {
		return nPSCounter;
	}
	public int getMissileCounter() {
		return missileCounter;
	}
	public int getPlayerLives() {
		return playerLives;
	}
	public int getPlayerScore() {
		return playerScore;
	}
	public int getGameTick() {
		return gameTick;
	}
	public boolean checkPlayerShip() {
		return playerShipSpawned;
	}
	public void SpawnSpaceStation() { //Spawns Space Station
		if (spaceStationSpawned == false) {
			SpaceStation spaceStation = new SpaceStation(10,10,255,255,255);
			theGameCollection.add(spaceStation);
			spaceStationSpawned = true;
			System.out.println("Space Station spawned");
		} else {
			System.out.println("Only one Space Station allowed");
		}
	}
	public void fireMissile() {//fires missiles for NPS
		IIterator theElements = theGameCollection.getIterator();
		while (theElements.hasNext() ) {
			if(theElements.getNext() instanceof MissileLauncher) {
				MissileLauncher firing = (MissileLauncher) theGameCollection.getObject(theElements.getCurrElementIndex());
				theGameCollection.add(firing.fire());
				missileCounter++;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}
	}
	public void firePlayerMissile() { //fires missiles for Player
		IIterator theElements = theGameCollection.getIterator();
		while (theElements.hasNext() ) {
			if(theElements.getNext() instanceof SteerableMissileLauncher) {
				SteerableMissileLauncher firing = (SteerableMissileLauncher) theGameCollection.getObject(theElements.getCurrElementIndex());
				theGameCollection.add(firing.fire());
				missileCounter++;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}

	}
	public void HyperSpaceJump() { //Moves the player back to center of map
		IIterator theElements = theGameCollection.getIterator();
		if(playerShipSpawned == true) {
			while (theElements.hasNext() ) {
				if(theElements.getNext() instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) theGameCollection.getObject(theElements.getCurrElementIndex());
					playerShip.setLoc(512,348);
					playerShip.playerMissileLauncher.setLoc(512,348);
					System.out.println("jump successful");
				}
			}
		} else {
			System.out.println("No PlayerShip Detected... cannot jump");
		}
	}
	public void IncreasePlayerSpeed() { //Increase player speed
		IIterator theElements = theGameCollection.getIterator();
		if(playerShipSpawned == true) {
			while (theElements.hasNext() ) {
				if(theElements.getNext() instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) theGameCollection.getObject(theElements.getCurrElementIndex());
					playerShip.IncreaseSpeed();
				}
			}
		} else {
			System.out.println("No PlayerShip Detected... cannot increase speed");
		}
	}
	public void DecreasePlayerSpeed() { //decrease player speed
		IIterator theElements = theGameCollection.getIterator();
		if(playerShipSpawned == true) {
			while (theElements.hasNext() ) {
				if(theElements.getNext() instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) theGameCollection.getObject(theElements.getCurrElementIndex());
					playerShip.DecreaseSpeed();
				}
			}
		} else {
			System.out.println("No PlayerShip Detected... cannot decrease speed");
		}
	}
	public void ChangePlayerShipDirection(int degree) { //change player direction by 10 degrees
		IIterator theElements = theGameCollection.getIterator();
		if(playerShipSpawned == true) {
			while (theElements.hasNext() ) {
				if(theElements.getNext() instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) theGameCollection.getObject(theElements.getCurrElementIndex());
					playerShip.ChangeDirection(degree);
				}
			}
		} else {
			System.out.print("No PlayerShip Detected... cannot turn");
		}
	}
	public void ChangePlayerShipLauncherDirection(int degree) { //change direction of player's missile launcher
		IIterator theElements = theGameCollection.getIterator();
		if(playerShipSpawned == true) {
			while (theElements.hasNext() ) {
				if(theElements.getNext() instanceof SteerableMissileLauncher) {
					SteerableMissileLauncher playerShipLauncher = (SteerableMissileLauncher) theGameCollection.getObject(theElements.getCurrElementIndex());
					playerShipLauncher.ChangeDirection(degree);
					System.out.println("launcher position changed");
				}
			}
		} else {
			System.out.println("No PlayerShip Detected... cannot turn");
		}
	}
	public void AddSupply() { //adds missiles
		IIterator theElements = theGameCollection.getIterator();
		if(playerShipSpawned == true) {
			while (theElements.hasNext() ) {
				if(theElements.getNext() instanceof SteerableMissileLauncher) {
					SteerableMissileLauncher playerShipLauncher = (SteerableMissileLauncher) theGameCollection.getObject(theElements.getCurrElementIndex());
					playerShipLauncher.AddSupply();
					System.out.println("Supply Added");
				}
			}
		} else {
			System.out.println("No PlayerShip Detected... cannot increase speed");
		}
	}
	public void PrintGameStatus() { //prints game progress, Game score To be added
		System.out.println("game time: " + gameTick + " || " + "Player lives: " + playerLives + " || " + "Game Score: " + "N/A");
	}
	public GameCollection getGameCollection() {
		return theGameCollection;
	}
	public void displayCollection() {
		IIterator theElements = theGameCollection.getIterator();
		while (theElements.hasNext()) {
			GameObject gob = (GameObject) theElements.getNext();
			System.out.println(gob);
			System.out.println("-----------------------------------------------------------------");
		}
	}
	public void DestroyMissile() { //destroys 1 missile
		IIterator theElements = theGameCollection.getIterator();
		if (missileCounter == 0) {
			System.out.println("There are no missiles");
			return;
		} else {
			while (theElements.hasNext()) {
				if(theElements.getNext() instanceof Missile) {
					Missile missile = (Missile) theGameCollection.getObject(theElements.getCurrElementIndex());
					theGameCollection.remove(missile);
					missileCounter--;
					System.out.println(nPSCounter + " missiles left");
					return;
				}
			}
		}
	}
	public void DestroyPlayerShip() { //destroys playership and loses life
		IIterator theElements = theGameCollection.getIterator();
		if (playerShipSpawned == true && playerLives > 1) {
			while (theElements.hasNext() ) {
				if(theElements.getNext() instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) theGameCollection.getObject(theElements.getCurrElementIndex());
					theGameCollection.remove(playerShip);
					theGameCollection.remove(playerShip.playerMissileLauncher);
					playerShipSpawned = false;
					playerLives--;
					SpawnPlayerShip();
					System.out.println(playerLives + " lives left");
					this.setChanged();
					this.notifyObservers(new GameWorldProxy(this));
					return;
				} 
			} 
		} else if (playerShipSpawned == false) {
				System.out.println("no Player Spawned");
		} else if (playerLives <= 1) {
				if(soundFlag == false) {
					loseSound.play();
				}
				  Boolean bOk = Dialog.show("GAME OVER", "Would You like to Start again", "Yes", "No");
				  if (bOk) {
					  new Game();
				  }
				  if (!bOk){
					  Display.getInstance().exitApplication();
				  }
			}
	
	}
	public void DestroyNonPlayerShip() { //destroys NPS
		IIterator theElements = theGameCollection.getIterator();
		if (nPSCounter == 0) {
			System.out.println("There are no nps");
			return;
		} else {
			while (theElements.hasNext() ) {
				if(theElements.getNext() instanceof NonPlayerShip) {
					NonPlayerShip nPS = (NonPlayerShip) theGameCollection.getObject(theElements.getCurrElementIndex());
					theGameCollection.remove(nPS);
					theGameCollection.remove(nPS.missileLauncher);
					nPSCounter--;
					playerScore += 10;
					this.setChanged();
					this.notifyObservers(new GameWorldProxy(this));
					System.out.println(nPSCounter + " nps left");
					return;
				}
			}
		}
	}
	public void DestroyAsteroid() { //destroys Asteroid
		IIterator theElements = theGameCollection.getIterator();
		if (asteroidCounter == 0) {
			System.out.println("There are no asteroids");
			return;
		} else {
			while (theElements.hasNext() ) {
				if(theElements.getNext() instanceof Asteroid) {
					Asteroid asteroid = (Asteroid) theGameCollection.getObject(theElements.getCurrElementIndex());
					theGameCollection.remove(asteroid);
					asteroidCounter--;
					playerScore+= 5;
					this.setChanged();
					this.notifyObservers(new GameWorldProxy(this));
					System.out.println(asteroidCounter + " asteroids left");
					return;
				} 
			}
		}
	}
	public void init() {
		// TODO Auto-generated method stub
		
	}

}