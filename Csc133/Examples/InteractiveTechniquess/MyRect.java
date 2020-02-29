package com.mycompany.IUI;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class MyRect extends GeometricShape  {
	//...[assign iShapeX and iShapeY to rect coordinates (upper left corner of rect 	
	//which is relative to the origin of the component) supplied in the constructor]
	int iShapeX;
	int iShapeY;
	int width, height; 
	int color;
	
	public MyRect(int iShapeX, int iShapey, int width, int height, int color) {
		this.iShapeX = iShapeX;
		this.iShapeY = iShapeY;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(color);
		int xLoc = pCmpRelPrnt.getX()+ iShapeX;// shape location relative
		int yLoc = pCmpRelPrnt.getY()+ iShapeY;// to parent’s origin
		if(isSelected()) {
			g.fillRect(xLoc, yLoc, width, height);
		}
		else{
			g.drawRect(xLoc, yLoc, width, height);
		}
	}
	
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int px = pPtrRelPrnt.getX(); // pointer location relative to
		int py = pPtrRelPrnt.getY(); // parent’s origin
		int xLoc = pCmpRelPrnt.getX()+ iShapeX;// shape location relative
		int yLoc = pCmpRelPrnt.getY()+ iShapeY;// to parent’s origin
		if ( (px >= xLoc) && (px <= xLoc+width) 
			&& (py >= yLoc) && (py <= yLoc+height) )
			return true; 
		else 
			return false;
	}
}

