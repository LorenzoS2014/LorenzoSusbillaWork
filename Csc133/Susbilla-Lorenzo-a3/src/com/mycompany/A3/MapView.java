package com.mycompany.A3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.codename1.ui.plaf.Border;
import com.mycompany.A3.interfacer.IDrawable;
import com.mycompany.A3.interfacer.IGameWorld;
import com.mycompany.A3.interfacer.IIterator;
import com.mycompany.A3.interfacer.IMoveable;

public class MapView extends Container implements Observer{
	IGameWorld gw;
	GameCollection go;
	IIterator gameIterator;
	public MapView(GameWorld gw) {
		this.gw = gw;
		go = gw.getGameCollection();
		gameIterator = go.getIterator();
		Container centerContainer = new Container();
		this.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.rgb(0,100,150)));
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.BLACK);
	    this.getAllStyles().setBorder(Border.createLineBorder(4,
														ColorUtil.rgb(229, 177, 58)));
		this.add(centerContainer);
	}
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(getX(),getY());
		for (IDrawable drawable : go.getGameObjects()) {
			drawable.draw(g, pCmpRelPrnt);
		}
	}
	

}
