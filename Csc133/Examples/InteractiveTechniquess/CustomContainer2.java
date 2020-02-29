package com.mycompany.IUI;
import java.util.Vector;
import com.codename1.ui.geom.Point;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;

public class CustomContainer2 extends Container{
		 private Graphics myGraphics;
		 public void paint(Graphics g){ 
			  myGraphics = g;
			  super.paint(g); 
			  myGraphics.setColor(ColorUtil.GREEN);
			  //empty rectangle appears in the CORRECT place (at the origin of this)
			  myGraphics.drawRect(getX(), getY(), 20, 40);
		 }
		 public void drawObj(){
		     repaint();
		     myGraphics.setColor(ColorUtil.BLUE);
		     //filled rectangle appears in the WRONG place and disappears next time 
		     //repaint() is called
		     // myGraphics.drawRect(getX(), getY(), 20, 40);
		     myGraphics.fillRect(getX(), getY(), 20, 40);
		 }
}	
