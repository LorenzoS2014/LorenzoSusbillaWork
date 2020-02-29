package com.mycompany.A2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class SpaceStation extends NonMoveable {
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

}
