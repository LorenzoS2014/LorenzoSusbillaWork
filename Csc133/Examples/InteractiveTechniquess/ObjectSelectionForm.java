package com.mycompany.IUI;

import java.util.Vector;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;

public class ObjectSelectionForm extends Form  {
	private Vector<GeometricShape> worldShapes = new Vector<GeometricShape>();
	CustomContainer centerContainer = new CustomContainer(worldShapes);
	public ObjectSelectionForm() {
	   setLayout(new BorderLayout());	
	   centerContainer.getAllStyles().setBgTransparency(255);
	   centerContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
       centerContainer.getAllStyles().setBorder(Border.createLineBorder(4,
													ColorUtil.MAGENTA));
	   add(BorderLayout.CENTER,centerContainer);
	   worldShapes.addElement(new MyRect(100, 100, 50, 50, ColorUtil.BLACK));
	   worldShapes.addElement(new MyRect(200, 200, 100, 100, ColorUtil.GREEN));
	   this.show();
	}
}
