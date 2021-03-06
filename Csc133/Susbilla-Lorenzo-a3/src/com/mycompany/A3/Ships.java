package com.mycompany.A3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

//both NPS and Player ship inherit this class
public abstract class Ships extends Moveable {
	public abstract String toString();
	private int color;
	private int speed;
	private int heading;
	private Point2D loc;
	private double y;
	private double x;
	private int size;
	
	public Ships(int speed, int heading,double x,double y,int r, int g, int b, int size) 
	{
		super(x,y,speed,heading,r,g,b, size);
		this.speed = super.getSpeed();
		this.heading = heading;
		this.x = super.getX();
		this.y = super.getY();
		this.loc = super.getLoc();
		this.color = ColorUtil.rgb(r, g, b);
		this.size = super.getSize();
		// TODO Auto-generated constructor stub
	}

	public void setLoc(Point2D point) {
		this.loc = point;
	}

	public Point2D getLoc() {
		return this.loc;
	}
}
