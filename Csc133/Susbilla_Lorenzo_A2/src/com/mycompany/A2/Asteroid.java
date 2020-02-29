package com.mycompany.A2;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;
//Asteroid is one of the obstacles to the player
//size from 6-30, random speed,random heading, random location, color
public class Asteroid extends Moveable{
	private Random random = new Random();
	private int size = 6 + random.nextInt(25);
	private int speed;
	private Point2D loc;
	private int heading;
	private int color;
	public Asteroid(double x, double y, int speed, int heading, int r, int g, int b) {
		super(x, y, speed, heading, r, g, b);
		this.speed = speed;
		this.heading = heading;
		this.loc = super.getLoc();
		this.color = ColorUtil.rgb(r, g, b); 
	}
	@Override
	public String toString() { //String returns Asteroid Location,size,heading,speed,color
		String string = "Asteroid Location: (" + loc + ") " + " size: " + size + " heading: " + heading +" speed: "+ speed  +  " color: " + "[" + ColorUtil.red(color) + "," + ColorUtil.green(color)+ "," + ColorUtil.blue(color) + "]";
		return string;
	}


}
