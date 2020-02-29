package com.mycompany.A3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

//Non moveable objects inherit this class 
public abstract class NonMoveable extends GameObject {
		private double x;
		private double y;
		private Point2D loc;
		private int color;
	public NonMoveable(double x, double y, int r, int g, int b) {
		super(x, y, r, g, b);
		this.x = x;
		this.y = y;
		this.loc = super.getLoc();
		this.color = ColorUtil.rgb(r, g, b);
	}
	public abstract String toString();

}
