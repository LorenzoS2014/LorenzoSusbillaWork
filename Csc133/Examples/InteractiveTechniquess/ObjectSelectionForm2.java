package com.mycompany.IUI;

import java.util.Vector;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;

public class ObjectSelectionForm2 extends Form  {
	CustomContainer3 centerContainer = new CustomContainer3();
	public ObjectSelectionForm2() {
	   setLayout(new BorderLayout());	
	   centerContainer.getAllStyles().setBgTransparency(255);
	   centerContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
       centerContainer.getAllStyles().setBorder(Border.createLineBorder(4,
													ColorUtil.MAGENTA));
	   add(BorderLayout.CENTER,centerContainer);
       this.show();
	}
}
