package com.mycompany.A3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.A3.interfacer.ISteerable;

//PlayerShip is extended from the Ship Abstract class and implemts the ISteerable interface
//This is a user controlled object that players will use
public class PlayerShip extends Ships implements ISteerable{
	private int speed;
	private int heading;
	private int color;
	private Point2D loc;
	private int size;
	private Point top, bottomLeft, bottomRight;	
	SteerableMissileLauncher playerMissileLauncher;
	public PlayerShip(int speed, int heading, int x, int y, int r, int g, int b, int size) {
		super(speed, heading, x, y, r, g, b, size);
		this.speed = speed;
		this.heading = heading;
		this.loc = super.getLoc();
		this.playerMissileLauncher = new SteerableMissileLauncher(this.getX(), this.getY(), this.speed, this.heading, 0, 0, 0, 10, 0, this);
		this.color = ColorUtil.rgb(r, g, b);
		this.size = 300;
		top = new Point (0, size/2);
		bottomLeft = new Point (-size/2, -size/2);
		bottomRight = new Point (size/2 , -size/2);
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
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(ColorUtil.rgb(75,213,238));
		int xLoc = (int) (pCmpRelPrnt.getX()+ loc.getX()); // shape location relative
		int yLoc = (int) (pCmpRelPrnt.getY()+ loc.getY()); // to parents origin
		g.drawLine(xLoc + top.getX(), yLoc +top.getY(), 
				xLoc +bottomLeft.getX(),yLoc+bottomLeft.getY());  
		g.drawLine(xLoc+bottomLeft.getX(), yLoc+bottomLeft.getY(), 
				xLoc+bottomRight.getX(), yLoc+bottomRight.getY());
		g.drawLine(xLoc+bottomRight.getX(),yLoc+bottomRight.getY(), 
				xLoc+top.getX(), yLoc+top.getY());
		
		
	}


}
