package com.mycompany.IUI;
import java.util.Vector;
import com.codename1.ui.geom.Point;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;

public class CustomContainer3 extends Container{
	private int iPx = 0;
	private int iPy = 0;

	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(ColorUtil.BLACK);
		//make the point location relative to the component's parent's origin 
		//and then draw the rectangle (below un-filled rect would appear in the CORRECT location)
		g.drawRect(iPx-getParent().getAbsoluteX(),iPy-getParent().getAbsoluteY(),20,40);
		//below filled rect would appear in the WRONG location
		//g.fillRect(iPx,iPy, 20,40);
		g.fillRect(iPx-getParent().getAbsoluteX(),iPy-getParent().getAbsoluteY(),20,40);
	}

	@Override
	public void pointerPressed(int x,int y){
		//save the pointer pressed location 
		//it is relative the to the screen origin
		iPx = x;
		iPy = y;
		repaint();
	}
}	
