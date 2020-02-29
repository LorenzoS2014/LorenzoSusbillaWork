package com.mycompany.A1;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class Game extends Form {
	private GameWorld gw;
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	private void play() {
		Label myLabel=new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
					String sCommand=myTextField.getText().toString();
					myTextField.clear();
					switch (sCommand.charAt(0)){
						case 'a':
							gw.SpawnAsteroid();
							break;
						case 'y':
							gw.SpawnNonPlayerShip();
							break;
						case 'b':
							gw.SpawnSpaceStation();
							break;
						case 's':
							gw.SpawnPlayerShip();
							break;
						case 'i':
							gw.IncreasePlayerSpeed();
							break;
						case 'd':
							gw.DecreasePlayerSpeed();
							break;
						case 'm':
							gw.GameObjectToString();
							break;
						case 'l':
							gw.ChangePlayerShipDirection(-10);
							break;
						case '<':
							gw.ChangePlayerShipLauncherDirection(-10);
							break;	
						case 'L':
							gw.fireMissile();
							break;
						case 'j':
							gw.HyperSpaceJump();
							break;
						case 'n':
							gw.AddSupply();
							break;
						case 'k':
							gw.DestroyAsteroid();
							gw.DestroyMissile();
							break;
						case 'e':
							gw.DestroyNonPlayerShip();
							gw.DestroyMissile();
							break;
						case 'E':
							gw.DestroyPlayerShip();
							gw.DestroyMissile();
							break;
						case 'f':
							gw.firePlayerMissile();
							break;
						case 'r':
							gw.ChangePlayerShipDirection(10);
							break;
						case 'x':
							gw.DestroyAsteroid();
							gw.DestroyAsteroid();
							break;
						case 'c':
							gw.DestroyPlayerShip();
							gw.DestroyAsteroid();
							break;
						case 'I':
							gw.DestroyAsteroid();
							gw.DestroyNonPlayerShip();
							break;
						case 'h':
							gw.DestroyPlayerShip();
							gw.DestroyNonPlayerShip();
							break;
						case 't':
							gw.Move();
							break;
						case 'p':
							gw.PrintGameStatus();
							break;
						case 'q':
							System.exit(0);
							break;
							
					} //switch
			} //actionPerformed
		} //new ActionListener()
			); //addActionListener
	}
}
