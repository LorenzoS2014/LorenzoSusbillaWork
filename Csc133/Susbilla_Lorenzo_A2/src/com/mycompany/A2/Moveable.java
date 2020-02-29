package com.mycompany.A2;

import java.util.Random;

import com.codename1.ui.geom.Point2D;
import com.mycompany.A2.interfaces.IMoveable;
//all moveable objects inhert this class
public abstract class Moveable extends GameObject implements IMoveable {
	Random random = new Random();
	private int speed;
	private int heading;
	private double x;
	private double y;
	private Point2D loc;
	public abstract String toString();
	public Moveable(double x, double y, int speed, int heading, int r,int g, int b) {
		super(x, y, r, g, b);
		this.y = super.getY();
		this.x = super.getX();
		this.SetColor(r, g, b);
		this.loc= super.getLoc();
		this.speed = speed;
		this.heading = heading;
		// TODO Auto-generated constructor stub
	}
	//returns any moveable objects speed
	public int getSpeed() {
		return this.speed;
	}
	//sets speed
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//gets heading
	public int getHeading() {
		return this.heading;
	}
	//sets heading
	public void setHeading(int heading) {
		this.heading = heading;
	}
	@Override
	public void move() { //All moving objects follows this algorithm
		 int theata = 90 - heading;
		 double deltaX = Math.round(Math.cos(theata) * speed);
		 double deltaY = Math.round(Math.sin(theata) * speed);
		 y = getLoc().getY() + deltaY;
		 x = getLoc().getX() + deltaX;
		 loc.setX(x);
		 loc.setY(y);
		  
		
	}

}
