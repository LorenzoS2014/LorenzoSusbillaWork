package com.mycompany.A1;

import com.codename1.ui.geom.Point2D;

public class Missile extends Moveable{
	private int speed;
	private int heading;
	private double x;
	private double y;
	private int color;
	private Point2D loc;
	public Missile(double x, double y, int speed, int heading, int r, int g, int b) {
		super(x, y, speed, heading, r, g, b);
		this.speed = speed;
		this.heading = heading;
		this.x = x;
		this.y = y;
		this.loc = super.getLoc();
	}

	@Override
	public String toString() {
		String string = "Missle Location: " + "(" + loc + ")" + " speed: " + speed + " heading: " + heading;
		return string;
	}
	
}


