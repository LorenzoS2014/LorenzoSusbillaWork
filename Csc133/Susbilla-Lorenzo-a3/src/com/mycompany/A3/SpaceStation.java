package com.mycompany.A3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.A3.interfacer.ICollider;

public class SpaceStation extends NonMoveable implements ICollider {
	Random random = new Random();
	private double x;
	private double y;
	private Point2D loc;
	private int color;
	private int blinkRate = random.nextInt(5);
	public SpaceStation(double x, double y, int r, int g, int b) {
		super(x, y, r, g, b);
		this.x = x;
		this.y = y;
		this.loc = super.getLoc();
		this.color = ColorUtil.rgb(r, g, b);
	}

	@Override
	public String toString() { //returns location, color, blinkrate
		String string = "SpaceStation location: " + " (" + loc + ") " + " color: " + "[" + ColorUtil.red(color) + "," + ColorUtil.green(color)+ "," + ColorUtil.blue(color) + "]" + " Blinkrate: " + blinkRate;
		return string;
	}


	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(ColorUtil.rgb(0,213,100));
		int xLoc = (int) (pCmpRelPrnt.getX()+ loc.getX()); // shape location relative
		int yLoc = (int) (pCmpRelPrnt.getY()+ loc.getY()); // to parents origin
		g.fillArc(xLoc, yLoc, 200, 200, 0, 360);
		
	}

	@Override
	public void move(Dimension dCmpSize) {
	}

	@Override
	public boolean collidesWith(ICollider otherObject) {
		return false;
	}

	@Override
	public void handleCollision(ICollider otherObject) {
		
	}



}
