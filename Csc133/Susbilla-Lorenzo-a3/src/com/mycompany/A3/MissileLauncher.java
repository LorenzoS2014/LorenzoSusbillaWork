package com.mycompany.A3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
//missile launcher are instantiated in the NPS and the Player Class alike
//holds missiles 
public class MissileLauncher extends Moveable {
	private int speed;
	private int heading;
	private double x;
	private double y;
	private int color;
	private Point2D loc;
	private int launcherSize;
	private int missilesLeft;
	private int size;
	public MissileLauncher(double x, double y, int speed, int heading, int r, int g, int b, int launcherSize, int size) {
		super(x, y, speed, heading, r, g, b, size);
		this.speed = speed;
		this.heading = heading;
		this.x = x;
		this.y = y;
		this.loc = super.getLoc();
		this.launcherSize = launcherSize;
		this.missilesLeft = this.launcherSize;
		this.color = ColorUtil.rgb(r, g, b);
		this.size = size;
	}
	//fires a missile
	public GameObject fire() {
		if (missilesLeft == 0) {
			System.out.println("no missiles left");
			return null;
		} else {
			System.out.println("firing missile");
			Missile missile = new Missile(this.x, this.y, this.speed + 10, this.heading, 0, 0, 0, 0, this.getLoc());
			missilesLeft -= 1;
			return missile;
		}
	}

	@Override
	public String toString() { //string returns the location,speed,heading,and how many missiles left
		String string = "MissleLauncher Location: " + "(" + loc + ")" + " speed: " + speed + " heading: " + heading + " Missiles left: " + missilesLeft;
		return string;
	}
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		
	}

}


