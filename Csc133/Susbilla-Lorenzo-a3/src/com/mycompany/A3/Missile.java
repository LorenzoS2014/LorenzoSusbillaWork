package com.mycompany.A3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.A3.interfacer.ISelectable;

public class Missile extends Moveable implements ISelectable{
	private int speed;
	private int heading;
	private double x;
	private double y;
	private int color;
	private Point2D loc;
	private int size;
	private boolean isSelected;
	Point2D firingFrom;
	public Missile(double x, double y, int speed, int heading, int r, int g, int b, int size, Point2D firingFrom) {
		super(x, y, speed, heading, r, g, b, size);
		this.speed = speed;
		this.heading = heading;
		this.x = x;
		this.y = y;
		this.loc = firingFrom;
		this.size = size;
	}

	@Override
	public String toString() {
		String string = "Missle Location: " + "(" + loc + ")" + " speed: " + speed + " heading: " + heading;
		return string;
	}
	public void setSelected(boolean yesNo) { isSelected = yesNo; }
	public boolean isSelected() { return isSelected; }

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(ColorUtil.WHITE);
		int locX = (int) (pCmpRelPrnt.getX()+ loc.getX());
		int locY = (int) (pCmpRelPrnt.getY()+ loc.getY());
		if(isSelected()) {
			g.fillRect(locX, locY, 7, 40);
		}
		else {
			g.drawRect(locX, locY, 7, 40);
		}
	}
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int px = pPtrRelPrnt.getX(); // pointer location relative to
		int py = pPtrRelPrnt.getY(); // parents origin
		int xLoc = (int) (pCmpRelPrnt.getX()+ loc.getX());// shape location relative
		int yLoc = (int) (pCmpRelPrnt.getY()+ loc.getY());// to parents origin
		if ( (px >= xLoc) && (px <= xLoc+7) 
			&& (py >= yLoc) && (py <= yLoc+40) )
			return true; 
		else 
			return false;
	}

	
}


