package com.mycompany.IUI;
import java.util.Vector;
import com.codename1.ui.geom.Point;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;

public class CustomContainer extends Container {
	Vector<GeometricShape> worldShapes;
	public CustomContainer(Vector<GeometricShape> worldShapes) {
		this.worldShapes = worldShapes;
	}

	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(getX(), getY());
		for (int i = 0; i < worldShapes.size(); i++)
			worldShapes.elementAt(i).draw(g, pCmpRelPrnt);
	}

	public void pointerPressed(int x, int y) {
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
		for (int i = 0; i < worldShapes.size(); i++) {
		    if (worldShapes.elementAt(i).contains(pPtrRelPrnt, pCmpRelPrnt))
				worldShapes.elementAt(i).setSelected(true);
			else
				worldShapes.elementAt(i).setSelected(false);
			repaint();
		}
	}
}
