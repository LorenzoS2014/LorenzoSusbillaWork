package com.mycompany.A3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.UITimer;
import com.mycompany.A3.interfacer.IGameWorld;

public class PointView extends Container implements Observer {
	
	private Label pointsValue;
	private Label playerLivesValue;
	private Label missileCounterValue;
	private Label gameTickValue;
	public PointView() {
		//Displays points
		Label pointsTextLabel = new Label("Points: ");
		pointsValue = new Label("");
		pointsTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		//Displays player Lives
		Label playerLivesText = new Label("Lives: ");
		playerLivesValue = new Label("");
		playerLivesText.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		//missile counter
		Label missilesCounterText = new Label("Missiles: ");
		missileCounterValue = new Label("");
		missilesCounterText.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		//game time
		Label gameTickText = new Label("Time: ");
		gameTickValue = new Label("");
		gameTickText.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		Container container = new Container();
		container.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		container.add(pointsTextLabel);
		container.add(pointsValue);
		container.add(playerLivesText);
		container.add(playerLivesValue);
		container.add(missilesCounterText);
		container.add(missileCounterValue);
		container.add(gameTickText);
		container.add(gameTickValue);
		this.add(container);
		
	}
	@Override
	public void update(Observable o, Object arg) {
		IGameWorld gw = (IGameWorld) arg;
		int score = gw.getPlayerScore();
		int lives = gw.getPlayerLives();
		int missiles = gw.getMissileCounter();
		int time = gw.getGameTick();
		pointsValue.setText("" + (score > 99 ? "" : "0") + (score > 9 ? "" : "0") + score);
		playerLivesValue.setText(""+ (score > 9 ? "" : "0") + lives);
		missileCounterValue.setText(""+ (score > 9 ? "" : "0") + missiles);
		gameTickValue.setText("" + (score > 99 ? "" : "0") + (score > 9 ? "" : "0") + time);
		this.repaint();
		// TODO Auto-generated method stub 
		
	}


}
