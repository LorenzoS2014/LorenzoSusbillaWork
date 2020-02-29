package com.mycompany.A3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.A3.interfacer.IDrawable;
//Asteroid is one of the obstacles to the player
//size from 6-30, random speed,random heading, random location, color
public class Asteroid extends Moveable implements IDrawable{
	private Random random = new Random();
	private int size;
	private int speed;
	private int incX, incY;
	private Point2D loc;
	private int heading;
	private int color;
	public Asteroid(double x, double y, int speed, int heading, int r, int g, int b, int size) {
		super(x, y, speed, heading, r, g, b, size);
		this.speed = super.getSpeed();
		this.heading = heading;
		this.loc = super.getLoc();
		this.color = ColorUtil.rgb(139, 69, 19); 
		this.size = 20 + random.nextInt(50);
		this.incX = super.getSpeed();
		this.incY = super.getSpeed();
	}
	@Override
	public String toString() { //String returns Asteroid Location,size,heading,speed,color
		String string = "Asteroid Location: (" + loc + ") " + " size: " + size + " heading: " + heading +" speed: "+ speed  +  " color: " + "[" + ColorUtil.red(color) + "," + ColorUtil.green(color)+ "," + ColorUtil.blue(color) + "]";
		return string;
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(color);
		int locX = (int) (pCmpRelPrnt.getX()+ loc.getX());
		int locY = (int) (pCmpRelPrnt.getY()+ loc.getY());
		g.fillArc(locX, locY, size, size, 0, 360);
		
	}

}
