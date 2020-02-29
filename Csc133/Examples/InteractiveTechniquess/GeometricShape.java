package com.mycompany.IUI;

import com.codename1.ui.geom.Point;

import com.codename1.ui.Graphics;

abstract public class GeometricShape implements ISelectable {
	private boolean isSelected;
	public void setSelected(boolean yesNo) { isSelected = yesNo; }
	public boolean isSelected() { return isSelected; }
	public abstract void draw(Graphics g, Point pCmpRelPrnt);
	public abstract boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
}
