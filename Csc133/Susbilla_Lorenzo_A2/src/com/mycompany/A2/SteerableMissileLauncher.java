package com.mycompany.A2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;
import com.mycompany.A2.interfaces.ISteerable;

//steerable missile launcher is used by playership
public class SteerableMissileLauncher extends MissileLauncher implements ISteerable{
	private int speed;
	private int heading;
	private double x;
	private double y;
	private int color;
	private Point2D loc;
	private int launcherSize;
	private int missilesLeft;
	public SteerableMissileLauncher(double x, double y, int speed, int heading, int r, int g, int b, int launcherSize) {
		super(x, y, speed, heading, r, g, b, launcherSize);
		this.speed = speed;
		this.heading = heading;
		this.x = x;
		this.y = y;
		this.loc = super.getLoc();
		this.launcherSize = launcherSize;
		this.missilesLeft = this.launcherSize;
	}
	@Override
	public void ChangeDirection(int degree) { //changes directions
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
	public GameObject fire() { //fires missiles
		if (missilesLeft == 0) {
			System.out.println("no missiles left");
			return null;
		} else {
			System.out.println("firing missile");
			Missile missile = new Missile(this.x, this.y, this.speed + 10, this.heading, 0, 0, 0);
			missilesLeft -= 1;
			return missile;
		}
	}
	public void AddSupply() { //fills up missiles to launchersize 
		if(missilesLeft < launcherSize) {
			for(int i = missilesLeft; i < launcherSize;) {
				System.out.println("Added missile");
				missilesLeft++;		
				i++;
			}
		}
	}
	@Override
	public String toString() { //returns location,speed,heading, remaining missiles
		String string = "Player Ship Launcher Location: (" + loc + ") " + " speed: " + speed + " heading: " + heading + " Missiles left: " + missilesLeft;
		return string;
	}

}
