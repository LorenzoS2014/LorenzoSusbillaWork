package com.mycompany.A2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import com.mycompany.A2.interfaces.IGameWorld;
import com.mycompany.A2.interfaces.IIterator;
import com.mycompany.A2.interfaces.IMoveable;
//GameWorld holds and instantiates all of the objects and stores them
public class GameWorld extends Observable implements IGameWorld{
	private Random random = new Random();
	private GameCollection theGameCollection = new GameCollection();
	private boolean soundFlag;
	private int asteroidCounter;
	private int nPSCounter;
	private int missileCounter;
	private boolean playerShipSpawned = false; 
	private boolean spaceStationSpawned = false;
	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	private int playerLives = 3;
	private int playerScore;
	private int gameTick;
	public void init() {
		
	}
	public void SpawnPlayerShip() { //Spawns Player Ship
		if (playerShipSpawned == false) {
			PlayerShip playerShip = new PlayerShip(1, 0, 512, 348, 255,0, 0);
			if (playerLives == 3) {
				System.out.println("PlayerShip spawned");
			} else System.out.println("New Player Ship Spawned");
			theGameCollection.add(playerShip);
			theGameCollection.add(playerShip.playerMissileLauncher);
			playerShipSpawned = true;
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		} else { 
			System.out.println("PlayerShip already spawned");
		}
	}
	public void SpawnAsteroid() { //Spawns Asteroid
		Asteroid asteroid = new Asteroid(random.nextInt(1025), random.nextInt(786), random.nextInt(11), random.nextInt(361), 0, 255, 0);
		theGameCollection.add(asteroid);
		asteroidCounter++;
		System.out.println("Asteriod number " + asteroidCounter + " spawned");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void SpawnNonPlayerShip() { //Spawns NPS
		NonPlayerShip nonPlayerShip = new NonPlayerShip(random.nextInt(11), random.nextInt(361),random.nextInt(1025), random.nextInt(786), 0, 0, 255);
		theGameCollection.add(nonPlayerShip);
		theGameCollection.add(nonPlayerShip.missileLauncher);
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
	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}
	public boolean checkPlayerShip() {
		return playerShipSpawned;
	}
	public void SpawnSpaceStation() { //Spawns Space Station
		if (spaceStationSpawned == false) {
			SpaceStation spaceStation = new SpaceStation(0,0,255,255,255);
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
		/*for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof MissileLauncher) {
				MissileLauncher shooting = (MissileLauncher) gameObjects.get(i);
				gameObjects.add(shooting.fire());
				missileCounter++;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}*/
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
		/*for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof SteerableMissileLauncher) {
				SteerableMissileLauncher firing = (SteerableMissileLauncher) gameObjects.get(i);
				gameObjects.add(firing.fire());
				missileCounter++;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}*/
	}
	public void Move() {//Move all moveable objects in GameWorld
		IIterator theElements = theGameCollection.getIterator();
		gameTick++;
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		while (theElements.hasNext() ) {
			if(theElements.getNext() instanceof IMoveable) {
				IMoveable moveable = (IMoveable) theGameCollection.getObject(theElements.getCurrElementIndex());
				moveable.move();
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
			/*for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) gameObjects.get(i);
					playerShip.playerMissileLauncher.setLoc(x, y);
					playerShip.setLoc(512,348);
				}
			}
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof SteerableMissileLauncher) {
					SteerableMissileLauncher playerShipLauncher = (SteerableMissileLauncher) gameObjects.get(i);
					playerShipLauncher.setLoc(512,348);
				}
			}
			System.out.println("jump successful");*/
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
			/*for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) gameObjects.get(i);
					playerShip.IncreaseSpeed();
					System.out.println("Speed increased");
				}
			}*/
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
			/*for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) gameObjects.get(i);
					playerShip.DecreaseSpeed();
					System.out.println("Speed decreased ");
				}
			}*/
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
			/*for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) gameObjects.get(i);
					playerShip.ChangeDirection(degree);
				}
			}*/
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
			/*for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof SteerableMissileLauncher) {
					SteerableMissileLauncher playerShipLauncher = (SteerableMissileLauncher) gameObjects.get(i);
					playerShipLauncher.ChangeDirection(degree);
					System.out.println("launcher position changed");
				}
			}*/
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
			/*for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof SteerableMissileLauncher) {
					SteerableMissileLauncher playerShipLauncher = (SteerableMissileLauncher) gameObjects.get(i);
					playerShipLauncher.AddSupply();
					System.out.println("Supply Added");
				}
			}*/
		} else {
			System.out.println("No PlayerShip Detected... cannot increase speed");
		}
	}
	public void PrintGameStatus() { //prints game progress, Game score To be added
		System.out.println("game time: " + gameTick + " || " + "Player lives: " + playerLives + " || " + "Game Score: " + "N/A");
	}
	public void GameObjectToString() { //Prints all objects in world
		for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof GameObject) {
				GameObject gameObject = (GameObject) gameObjects.get(i);
				gameObject.toString();
				System.out.println(gameObject);
				System.out.println("====================================================================================");
			}
		}
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
			/*for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof Missile) {
					//Asteroid asteroid = (Asteroid) gameObjects.get(i);
					gameObjects.remove(i);
					missileCounter--;
					System.out.println(nPSCounter + " missiles left");
					return;
				} 
			}*/
		}
	}
	public void DestroyPlayerShip() { //destroys playership and loses life
		IIterator theElements = theGameCollection.getIterator();
		if (playerShipSpawned == true && playerLives > 0) {
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
		} else if (playerLives <= 0) {
				System.out.println("no lives left... GAME OVER");
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
			/*for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof NonPlayerShip) {
					NonPlayerShip nPS = (NonPlayerShip) gameObjects.get(i);
					gameObjects.remove(nPS);
					gameObjects.remove(nPS.missileLauncher);
					nPSCounter--;
					playerScore += 10;
					this.setChanged();
					this.notifyObservers(new GameWorldProxy(this));
					System.out.println(nPSCounter + " nps left");
					return;
				} 
			}*/
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

}