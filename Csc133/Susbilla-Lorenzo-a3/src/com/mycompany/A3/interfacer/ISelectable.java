package com.mycompany.A3.interfacer;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public interface ISelectable {
	public void setSelected(boolean yesNo);
	public boolean isSelected();
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
}
