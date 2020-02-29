package com.mycompany.A1;

import java.util.ArrayList;
import java.util.Random;
//GameWorld holds and instantiates all of the objects and stores them
public class GameWorld {
	Random random = new Random();
	private double randomSpawnX = random.nextInt(1025);
	private double randomSpawnY = random.nextInt(786);
	private int asteroidCounter;
	private int nPSCounter;
	private int missileCounter;
	private boolean playerShipSpawned = false; 
	private boolean spaceStationSpawned = false;
	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	private int playerLives = 3;
	private int gameTick;
	public void init() {
		
	}
	public void SpawnPlayerShip() { //Spawns Player Ship
		if (playerShipSpawned == false) {
			PlayerShip playerShip = new PlayerShip(1, 0, 512, 348, 255,0, 0);
			gameObjects.add(playerShip);
			gameObjects.add(playerShip.playerMissileLauncher);
			playerShipSpawned = true;
			System.out.println("PlayerShip spawned");
		} else { 
			System.out.println("PlayerShip already spawned");
		}
	}
	public void SpawnAsteroid() { //Spawns Asteroid
		Asteroid asteroid = new Asteroid(randomSpawnX, randomSpawnX, random.nextInt(11), random.nextInt(361), 0, 255, 0);
		gameObjects.add(asteroid);
		asteroidCounter++;
		System.out.println("Asteriod number " + asteroidCounter + " spawned");
	}
	public void SpawnNonPlayerShip() { //Spawns NPS
		NonPlayerShip nonPlayerShip = new NonPlayerShip(random.nextInt(11), random.nextInt(361), randomSpawnX, randomSpawnY, 0, 0, 255);
		//MissleLauncher missleLauncher = new MissleLauncher(nonPlayerShip.getX(), nonPlayerShip.getY(), nonPlayerShip.getSpeed(), nonPlayerShip.getHeading(), 0, 0, 0);
		gameObjects.add(nonPlayerShip);
		gameObjects.add(nonPlayerShip.missileLauncher);
		//gameObjects.add(missleLauncher);
		System.out.println("NPS spawned");
	}
	public void SpawnSpaceStation() { //Spawns Space Station
		if (spaceStationSpawned == false) {
			SpaceStation spaceStation = new SpaceStation(0,0,255,255,255);
			gameObjects.add(spaceStation);
			spaceStationSpawned = true;
			System.out.println("Space Station spawned");
		} else {
			System.out.println("Only one Space Station allowed");
		}
	}
	public void fireMissile() { //fires missiles for NPS
		for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof MissileLauncher) {
				MissileLauncher shooting = (MissileLauncher) gameObjects.get(i);
				gameObjects.add(shooting.fire());
				missileCounter++;
				return;
			}
		}
	}
	public void firePlayerMissile() { //fires missiles for Player
		for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof SteerableMissileLauncher) {
				SteerableMissileLauncher firing = (SteerableMissileLauncher) gameObjects.get(i);
				gameObjects.add(firing.fire());
				missileCounter++;
				return;
			}
		}
	}
	public void Move() { //Move all moveable objects in GameWorld
		gameTick++;
		for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof IMoveable) {
				IMoveable moveable = (IMoveable) gameObjects.get(i);
				moveable.move();
			}
		}
	}
	public void HyperSpaceJump() { //Moves the player back to center of map
		if(playerShipSpawned == true) {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) gameObjects.get(i);
					playerShip.setLoc(512,348);
				}
			}
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof SteerableMissileLauncher) {
					SteerableMissileLauncher playerShipLauncher = (SteerableMissileLauncher) gameObjects.get(i);
					playerShipLauncher.setLoc(512,348);
				}
			}
			System.out.println("jump successful");
		} else {
			System.out.println("No PlayerShip Detected... cannot jump");
		}
	}
	public void IncreasePlayerSpeed() { //Increase player speed
		if(playerShipSpawned == true) {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) gameObjects.get(i);
					playerShip.IncreaseSpeed();
					System.out.println("Speed increased");
				}
			}
		} else {
			System.out.println("No PlayerShip Detected... cannot increase speed");
		}
	}
	public void DecreasePlayerSpeed() { //decrease player speed
		if(playerShipSpawned == true) {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) gameObjects.get(i);
					playerShip.DecreaseSpeed();
					System.out.println("Speed decreased ");
				}
			}
		} else {
			System.out.println("No PlayerShip Detected... cannot decrease speed");
		}
	}
	public void ChangePlayerShipDirection(int degree) { //change player direction by 10 degrees
		if(playerShipSpawned == true) {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof PlayerShip) {
					PlayerShip playerShip = (PlayerShip) gameObjects.get(i);
					playerShip.ChangeDirection(degree);
				}
			}
		} else {
			System.out.print("No PlayerShip Detected... cannot turn");
		}
	}
	public void ChangePlayerShipLauncherDirection(int degree) { //change direction of player's missile launcher
		if(playerShipSpawned == true) {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof SteerableMissileLauncher) {
					SteerableMissileLauncher playerShipLauncher = (SteerableMissileLauncher) gameObjects.get(i);
					playerShipLauncher.ChangeDirection(degree);
					System.out.println("launcher position changed");
				}
			}
		} else {
			System.out.print("No PlayerShip Detected... cannot turn");
		}
	}
	public void AddSupply() { //adds missiles
		if(playerShipSpawned == true) {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof SteerableMissileLauncher) {
					SteerableMissileLauncher playerShipLauncher = (SteerableMissileLauncher) gameObjects.get(i);
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
	public void DestroyMissile() { //destroys 1 missile
		if (missileCounter == 0) {
			System.out.println("There are no missiles");
			return;
		} else {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof Missile) {
					//Asteroid asteroid = (Asteroid) gameObjects.get(i);
					gameObjects.remove(i);
					missileCounter--;
					System.out.println(nPSCounter + " missiles left");
					return;
				} 
			}
		}
	}
	public void DestroyPlayerShip() { //destroys playership and loses life

		if (playerShipSpawned == true && playerLives > 0) {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof PlayerShip) {
					//PlayerShip playerShip = (PlayerShip) gameObjects.get(i);
					gameObjects.remove(i);
					playerShipSpawned = false;
					playerLives--;
					SpawnPlayerShip();
					System.out.println(playerLives + " lives left");
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
		if (nPSCounter == 0) {
			System.out.println("There are no nps");
			return;
		} else {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof NonPlayerShip) {
					//Asteroid asteroid = (Asteroid) gameObjects.get(i);
					gameObjects.remove(i);
					nPSCounter--;
					System.out.println(nPSCounter + " nps left");
					return;
				} 
			}
		}
	}
	public void DestroyAsteroid() { //destroys Asteroid
		if (asteroidCounter == 0) {
			System.out.println("There are no asteroids");
			return;
		} else {
			for (int i = 0; i < gameObjects.size(); i++) {
				if(gameObjects.get(i) instanceof Asteroid) {
					//Asteroid asteroid = (Asteroid) gameObjects.get(i);
					gameObjects.remove(i);
					asteroidCounter--;
					System.out.println(asteroidCounter + " asteroids left");
					return;
				} 
			}
		}
	}
}