package com.mycompany.IUI;

import java.util.Vector;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;

public class PolyGon extends Form  {
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(ColorUtil.BLACK);	
		int xpoints[] = {25, 145, 25, 145, 25};
	    int ypoints[] = {25, 25, 145, 145, 25};
	    int npoints = 5;
		g.drawPolygon(xpoints, ypoints, npoints);
	}
	
	public PolyGon() {
		Container centerContainer = new Container();	
		setLayout(new BorderLayout());	
	    add(BorderLayout.CENTER,centerContainer);
        centerContainer.repaint();
	    this.show();
	}
}