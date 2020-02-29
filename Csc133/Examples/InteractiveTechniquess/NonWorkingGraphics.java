package com.mycompany.IUI;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class NonWorkingGraphics extends Form implements ActionListener{//not listed in the rest
       CustomContainer2 myCustomContainer = new CustomContainer2();

	  public NonWorkingGraphics() {		   //of the examples
		  
		  /* Code for a form with containers in different layout arrangements */
			setLayout(new BorderLayout());
			//top Container with the GridLayout positioned on the north 
			Button myButtonTest = new Button("Click Me");
			myButtonTest.getAllStyles().setPadding(LEFT,5);
			myButtonTest.getAllStyles().setPadding(RIGHT,5);
			myButtonTest.getAllStyles().setPadding(TOP,5);
			myButtonTest.getAllStyles().setPadding(BOTTOM,5);
			
			myCustomContainer.add(myButtonTest);
			
			myButtonTest.addActionListener(this);
			//setting the back ground color of center container to light gray
			myCustomContainer.getAllStyles().setBgTransparency(255);
			myCustomContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);

			add(BorderLayout.CENTER,myCustomContainer);
		
			this.show();
		  
	    }

	    public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
	    	myCustomContainer.drawObj();
	    }
	}

