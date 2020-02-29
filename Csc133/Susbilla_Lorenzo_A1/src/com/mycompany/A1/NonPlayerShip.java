package com.mycompany.A1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;
//NonPlayerShip is an obstacle to player that along with moving
//will also shoot up to 2 missiles at the player
//random size between 10-20,random speed,random heading,random heading
//has a missile Launcher size of 2
public class NonPlayerShip extends Ships {
	private Random random = new Random();
	private int size = random.nextInt(3) * 10;
	private int speed;
	private int heading;
	private Point2D loc;
	private double x;
	private double y;	
	private int color = ColorUtil.rgb(0, 0, 255);
	MissileLauncher missileLauncher;
	public NonPlayerShip(int speed, int heading, double x, double y, int r, int g, int b) {
		super(speed, heading, x, y, r, g, b);
		this.speed = speed;
		this.heading = heading;
		this.x = x;
		this.y = y;
		this.loc = super.getLoc();
		this.color = ColorUtil.rgb(r, g, b);
		this.missileLauncher = new MissileLauncher(this.x, this.y, this.speed, this.heading, 0, 0, 0, 2); //instantiates missile launcher
	}

	@Override
	public String toString() { //String returns NPS Location,size,heading,speed,color
		String string = "NonPlayerShip Location: (" + loc + ") " + " size: " + size + " heading: " + heading + " speed: " + speed + " color: " + "[" + ColorUtil.red(color) + "," + ColorUtil.green(color)+ "," + ColorUtil.blue(color) + "]";
		return string;
	}

}
