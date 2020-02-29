package com.mycompany.A3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.A3.interfacer.ICollider;
import com.mycompany.A3.interfacer.IDrawable;
import com.mycompany.A3.interfacer.IMoveable;

//all objects in game world are GAME OBJECTS
public abstract class GameObject implements IDrawable,IMoveable,ICollider {
	
	private int color;
	private double x;
	private double y;
	private Point2D loc;
	public abstract String toString();	
	public GameObject(double x, double y,int r, int g, int b) {
		this.loc = new Point2D(x,y);
		this.color = ColorUtil.rgb(r, g, b);
	}	
	public void setLoc(double x,double y) {
		// TODO Auto-generated method stub
		loc.setX(x);
		loc.setY(y);
	}
	public Point2D getLoc() {
		// TODO Auto-generated method stub
		return this.loc;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getX() {
		return this.x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getY() {
		return this.y;
	}
	public void SetColor(int r, int g, int b) {
		this.color = ColorUtil.rgb(r,g,b);
		
	}
	public int GetColor() {
		return color;
		
	}
	public abstract void draw(Graphics g, Point pCmpRelPrnt);
	
}
