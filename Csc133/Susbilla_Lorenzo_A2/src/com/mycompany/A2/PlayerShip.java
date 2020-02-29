package com.mycompany.A2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;
import com.mycompany.A2.interfaces.ISteerable;

//PlayerShip is extended from the Ship Abstract class and implemts the ISteerable interface
//This is a user controlled object that players will use
public class PlayerShip extends Ships implements ISteerable{
	private int speed;
	private int heading;
	private int color;
	private Point2D loc;
	SteerableMissileLauncher playerMissileLauncher;
	public PlayerShip(int speed, int heading, int x, int y, int r, int g, int b) {
		super(speed, heading, x, y, r, g, b);
		this.speed = speed;
		this.heading = heading;
		this.loc = super.getLoc();
		this.playerMissileLauncher = new SteerableMissileLauncher(512, 348, this.speed, this.heading, 0, 0, 0, 10);
		this.color = ColorUtil.rgb(r, g, b);
	}
	//Prints out PlayerShip location,heading,speed,color
	public String toString() {
		String string = "Player Ship Location: (" + this.loc + ") heading: " + this.heading  + " Speed: " + this.speed + " color: " + "[" + ColorUtil.red(color) + "," + ColorUtil.green(color)+ "," + ColorUtil.blue(color) + "]";
		return string;
	}
	//Increases Speed by 1
	public void IncreaseSpeed() {
		if (speed < 10) {
			speed+=1;
			System.out.println("Speed increased");
		} else { 
			System.out.println("Cannot increase speed");
		}
	}
	//Decrease Speed by 1
	public void DecreaseSpeed() {
		if (speed > 0) {
			speed-=1;
			System.out.println("Speed decreased ");
		} else {
			System.out.println("Cannot decrease speed");
		}
	}
	//Change direction (heading) by a parameter of degree
	public void ChangeDirection(int degree) {
		if (heading < 360 && heading != 0) {
			heading += degree;
		} else if (heading >= 360) {
			heading = 0;
			heading += degree;
		} else if (heading <= 0) {
			heading = 360;
			heading += degree;
		}
	}
	

}
