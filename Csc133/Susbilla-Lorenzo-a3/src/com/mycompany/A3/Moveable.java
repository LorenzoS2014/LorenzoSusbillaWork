package com.mycompany.A3;

import java.util.Random;

import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point2D;
import com.mycompany.A3.interfacer.ICollider;
import com.mycompany.A3.interfacer.IMoveable;
//all moveable objects inhert this class
public abstract class Moveable extends GameObject {
	Random random = new Random();
	private int speed;
	private int incX, incY;
	private int heading;
	private double x;
	private double y;
	private Point2D loc;
	private int size;
	private boolean deletable = false;
	public abstract String toString();
	public Moveable(double x, double y, int speed, int heading, int r,int g, int b, int size) {
		super(x, y, r, g, b);
		this.y = super.getY();
		this.x = super.getX();
		this.SetColor(r, g, b);
		this.loc= super.getLoc();
		this.speed = speed;
		this.heading = heading;
		this.incX = speed;
		this.incY = speed;
		this.size = size;
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
	public void move(Dimension dCmpSize) { //All moving objects follows this algorithm
		 int theata = (int) Math.toRadians(90 - heading);
		 double deltaX = Math.round(Math.cos(theata) * incX);
		 double deltaY = Math.round(Math.sin(theata) * incY);
		 y = getLoc().getY() + deltaY;
		 x = getLoc().getX() + deltaX;
		 loc.setX(x);
		 loc.setY(y);
		 if ( (x+size >= dCmpSize.getWidth()) || (x < 0) ) 
				incX = -incX ;
		 if ( (y+size >= dCmpSize.getHeight()) || (y < 0) ) 
				incY = -incY ;  
		
	}
	public int getSize() {
		return size;
	}
	public boolean collidesWith(ICollider otherObject) {
	boolean result = false;
		int thisCenterX = (int) (this.getLoc().getX() + (this.getSize()/2));
		int thisCenterY = (int) (this.getLoc().getY() +(((Moveable) otherObject).getSize()/2));
		int otherCenterX = (int) (((GameObject) otherObject).getLoc().getX() + (size/2));
		int otherCenterY = (int) (((GameObject) otherObject).getLoc().getY() + (size/2));
		
		int dx = thisCenterX - otherCenterX;
     	int dy = thisCenterY - otherCenterY;
		int distBetweenCentersSqr = (dx*dx + dy*dy);
		
		int thisRadius = this.getSize()/2;
		int otherRadius = ((Moveable) otherObject).getSize()/2;
		
		int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius
											+ otherRadius*otherRadius);
		if (distBetweenCentersSqr <= radiiSqr) {
			result = true;
		}		
		return result;
	}
	public void handleCollision(ICollider otherObject) {
		this.deletable = true;
		((Moveable) otherObject).setDeletable();
	}
	public boolean getDeletable( ) {
		return deletable;
	}
	public void setDeletable() {
		deletable = !deletable;
	}

}
