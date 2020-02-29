package com.mycompany.A2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.Border;
import com.mycompany.A2.interfaces.IIterator;

public class MapView extends Container implements Observer{
	public MapView() {
		Container container = new Container();
		container.add(new Label("To be constructed"));
		
		this.add(container);
	}
	@Override
	public void update(Observable o, Object arg) {
		GameWorld gw = (GameWorld)o;
		GameCollection go =  gw.getGameCollection();
		IIterator gameIterator = go.getIterator();
		/*while(gameIterator.hasNext()) {
			System.out.println(gameIterator.getNext());
		}*/
		
	}

}
