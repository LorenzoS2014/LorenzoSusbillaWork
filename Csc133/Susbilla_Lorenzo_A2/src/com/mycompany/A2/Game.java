package com.mycompany.A2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.A2.commands.AsteroidMissileDestroyCommand;
import com.mycompany.A2.commands.BlastAsteroidCommand;
import com.mycompany.A2.commands.ChangeDirectionLeftCommand;
import com.mycompany.A2.commands.ChangeDirectionRightCommand;
import com.mycompany.A2.commands.ChangeLauncherDirectionLeftCommand;
import com.mycompany.A2.commands.ChangeLauncherDirectionRightCommand;
import com.mycompany.A2.commands.CrashAsteroidsCommand;
import com.mycompany.A2.commands.DecreaseSpeedCommand;
import com.mycompany.A2.commands.DisplayCollectionCommand;
import com.mycompany.A2.commands.FireMissileCommand;
import com.mycompany.A2.commands.FirePlayerMissileCommand;
import com.mycompany.A2.commands.HyperSpaceCommand;
import com.mycompany.A2.commands.IncreaseSpeedCommand;
import com.mycompany.A2.commands.MoveCommand;
import com.mycompany.A2.commands.NPSAsteroidCrashCommand;
import com.mycompany.A2.commands.NPSMissileDestroyCommand;
import com.mycompany.A2.commands.NPSPlayerCrashCommand;
import com.mycompany.A2.commands.PlayerCrashAsteroidCommand;
import com.mycompany.A2.commands.PlayerMissileDestroyCommand;
import com.mycompany.A2.commands.QuitCommand;
import com.mycompany.A2.commands.ReloadMissilesCommand;
import com.mycompany.A2.commands.SaveCommand;
import com.mycompany.A2.commands.SpawnAsteroidCommand;
import com.mycompany.A2.commands.SpawnNpsCommand;
import com.mycompany.A2.commands.SpawnPlayerShipCommand;
import com.mycompany.A2.commands.SpawnSpaceStationCommand;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;

public class Game extends Form {
	private GameWorld gw;
	private PointView pv;
	private MapView mv;
	public Game() {
		gw = new GameWorld();
		pv = new PointView();
		mv = new MapView();
		gw.addObserver(pv);
		gw.addObserver(mv);
		gw.init();
		this.setLayout(new BorderLayout());
		setToolBar();		//ToolBar
		setTopContainer();	//Top Container
		setLeftBar();	//left Side
		setCenter();	//Center Container
		this.show();
	}
	private void setToolBar() {
		Toolbar asteroidToolBar = new Toolbar();
		asteroidToolBar.getAllStyles().setPadding(BOTTOM, 1);
		setToolbar(asteroidToolBar);
		Label testLabel = new Label("Asteroids");
		asteroidToolBar.setTitleComponent(testLabel);
		
		//Side Menu Add Player Ship
		Button AddPlayerShipButton = new Button("Spawn Playership");
		AddPlayerShipButton.getAllStyles().setBgTransparency(255);
		AddPlayerShipButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		AddPlayerShipButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		AddPlayerShipButton.getAllStyles().setPadding(TOP, 1);
		AddPlayerShipButton.getAllStyles().setPadding(BOTTOM, 1);
		AddPlayerShipButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		SpawnPlayerShipCommand addPlayerShipCommand = new SpawnPlayerShipCommand(gw);
		AddPlayerShipButton.setCommand(addPlayerShipCommand);
		asteroidToolBar.addComponentToSideMenu(AddPlayerShipButton);
		
		//Side Menu Spawn Asteroid
		Button AddAsteroidButton = new Button("Spawn Asteroid");
		AddAsteroidButton.getAllStyles().setBgTransparency(255);
		AddAsteroidButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		AddAsteroidButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		AddAsteroidButton.getAllStyles().setPadding(TOP, 1);
		AddAsteroidButton.getAllStyles().setPadding(BOTTOM, 1);
		AddAsteroidButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		SpawnAsteroidCommand addAsteroidCommand = new SpawnAsteroidCommand(gw);
		AddAsteroidButton.setCommand(addAsteroidCommand);
		asteroidToolBar.addComponentToSideMenu(AddAsteroidButton);
		
		//Side Menu Spawn Space Station
		Button AddSpaceStationButton = new Button("Spawn SpaceStation");
		AddSpaceStationButton.getAllStyles().setBgTransparency(255);
		AddSpaceStationButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		AddSpaceStationButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		AddSpaceStationButton.getAllStyles().setPadding(TOP, 1);
		AddSpaceStationButton.getAllStyles().setPadding(BOTTOM, 1);
		AddSpaceStationButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		SpawnSpaceStationCommand addSpaceStationCommand = new SpawnSpaceStationCommand(gw);
		AddSpaceStationButton.setCommand(addSpaceStationCommand);
		asteroidToolBar.addComponentToSideMenu(AddSpaceStationButton);
		
		//Side Menu Reload Missiles
		Button reloadMissilesButton = new Button("Reload Missiles");
		reloadMissilesButton.getAllStyles().setBgTransparency(255);
		reloadMissilesButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		reloadMissilesButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		reloadMissilesButton.getAllStyles().setPadding(TOP, 1);
		reloadMissilesButton.getAllStyles().setPadding(BOTTOM, 1);
		reloadMissilesButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		ReloadMissilesCommand reloadMissilesCommand = new ReloadMissilesCommand(gw);
		reloadMissilesButton.setCommand(reloadMissilesCommand);
		asteroidToolBar.addComponentToSideMenu(reloadMissilesButton);
		
		//Side Menu move button
		Button MoveButton = new Button("Move");
		MoveButton.getAllStyles().setBgTransparency(255);
		MoveButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		MoveButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		MoveButton.getAllStyles().setPadding(TOP, 1);
		MoveButton.getAllStyles().setPadding(BOTTOM, 1);
		MoveButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		MoveCommand moveCommand = new MoveCommand(gw);
		MoveButton.setCommand(moveCommand);
		asteroidToolBar.addComponentToSideMenu(MoveButton);
		
		//Crash Asteroid
		Button CrashAsteroidsButton = new Button("Crash Asteroids");
		CrashAsteroidsButton.getAllStyles().setBgTransparency(255);
		CrashAsteroidsButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		CrashAsteroidsButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		CrashAsteroidsButton.getAllStyles().setPadding(TOP, 1);
		CrashAsteroidsButton.getAllStyles().setPadding(BOTTOM, 1);
		CrashAsteroidsButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		CrashAsteroidsCommand crashAsteroidsCommand = new CrashAsteroidsCommand(gw);
		CrashAsteroidsButton.setCommand(crashAsteroidsCommand);
		asteroidToolBar.addComponentToSideMenu(CrashAsteroidsButton);
		
		//Blast asteroid
		Button BlastAsteroidButton = new Button("Blast Asteroid");
		BlastAsteroidButton.getAllStyles().setBgTransparency(255);
		BlastAsteroidButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		BlastAsteroidButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		BlastAsteroidButton.getAllStyles().setPadding(TOP, 1);
		BlastAsteroidButton.getAllStyles().setPadding(BOTTOM, 1);
		BlastAsteroidButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		BlastAsteroidCommand blastAsteroidCommand = new BlastAsteroidCommand(gw);
		BlastAsteroidButton.setCommand(blastAsteroidCommand);
		asteroidToolBar.addComponentToSideMenu(BlastAsteroidButton);
		
		//Crash Player into Asteroid
		Button plyrCrshAstr = new Button("Player Crash into Asteroid");
		plyrCrshAstr.getAllStyles().setBgTransparency(255);
		plyrCrshAstr.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		plyrCrshAstr.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		plyrCrshAstr.getAllStyles().setPadding(TOP, 1);
		plyrCrshAstr.getAllStyles().setPadding(BOTTOM, 1);
		plyrCrshAstr.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		PlayerCrashAsteroidCommand plyrCrshAstrCommand = new PlayerCrashAsteroidCommand(gw);
		plyrCrshAstr.setCommand(plyrCrshAstrCommand);
		asteroidToolBar.addComponentToSideMenu(plyrCrshAstr);
		
		Label optionLabel = new Label("Options");
		optionLabel.getAllStyles().setBgTransparency(0);
		optionLabel.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		optionLabel.getAllStyles().setBgColor(ColorUtil.BLUE);
		asteroidToolBar.addComponentToSideMenu(optionLabel);
		Command volumeCheck = new Command("Volume check");
		CheckBox volumeBox = new CheckBox("Volume");
		volumeBox.getAllStyles().setBgTransparency(255);
		volumeBox.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		volumeCheck.putClientProperty("SideComponent", volumeBox);
		asteroidToolBar.addComponentToSideMenu(volumeBox);
		
		Button SaveButton = new Button("Save");
		SaveCommand Save = new SaveCommand();
		SaveButton.setCommand(Save);
		addKeyListener('S', Save);
		asteroidToolBar.addCommandToOverflowMenu(Save);
		Button QuitButton = new Button("Quit");
		QuitCommand Quit = new QuitCommand(gw);
		QuitButton.setCommand(Quit);
		addKeyListener('q', Quit);
		asteroidToolBar.addCommandToOverflowMenu(Quit);
		
		
	}
	private void setTopContainer() {
		add(BorderLayout.NORTH,pv);
	}
	private void setLeftBar() {
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		
		//Spawn Player Ship Button
		Button AddPlayerShipButton = new Button("Spawn Playership");
		AddPlayerShipButton.getAllStyles().setBgTransparency(255);
		AddPlayerShipButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		AddPlayerShipButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		AddPlayerShipButton.getAllStyles().setPadding(TOP, 1);
		AddPlayerShipButton.getAllStyles().setPadding(BOTTOM, 1);
		AddPlayerShipButton.getAllStyles().setBorder(Border.createLineBorder(4,
			ColorUtil.BLACK));
		SpawnPlayerShipCommand addPlayerShipCommand = new SpawnPlayerShipCommand(gw);
		AddPlayerShipButton.setCommand(addPlayerShipCommand);
		addKeyListener('s', addPlayerShipCommand);
		leftContainer.add(AddPlayerShipButton);
		
		//Spawn Asteroid
		Button AddAsteroidButton = new Button("Spawn Asteroid");
		AddAsteroidButton.getAllStyles().setBgTransparency(255);
		AddAsteroidButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		AddAsteroidButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		AddAsteroidButton.getAllStyles().setPadding(TOP, 1);
		AddAsteroidButton.getAllStyles().setPadding(BOTTOM, 1);
		AddAsteroidButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		SpawnAsteroidCommand addAsteroidCommand = new SpawnAsteroidCommand(gw);
		AddAsteroidButton.setCommand(addAsteroidCommand);
		addKeyListener('a', addAsteroidCommand);
		leftContainer.add(AddAsteroidButton);
		
		//Spawn Non Player Ship
		Button AddNonPlayerShip = new Button("Spawn NonPlayership");
		AddNonPlayerShip.getAllStyles().setBgTransparency(255);
		AddNonPlayerShip.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		AddNonPlayerShip.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		AddNonPlayerShip.getAllStyles().setPadding(TOP, 1);
		AddNonPlayerShip.getAllStyles().setPadding(BOTTOM, 1);
		AddNonPlayerShip.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		SpawnNpsCommand addNpsCommand = new SpawnNpsCommand(gw);
		AddNonPlayerShip.setCommand(addNpsCommand);
		addKeyListener('y', addNpsCommand);
		leftContainer.add(AddNonPlayerShip);
		
		//Spawn Space Station
		Button AddSpaceStationButton = new Button("Spawn SpaceStation");
		AddSpaceStationButton.getAllStyles().setBgTransparency(255);
		AddSpaceStationButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		AddSpaceStationButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		AddSpaceStationButton.getAllStyles().setPadding(TOP, 1);
		AddSpaceStationButton.getAllStyles().setPadding(BOTTOM, 1);
		AddSpaceStationButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		SpawnSpaceStationCommand addSpaceStationCommand = new SpawnSpaceStationCommand(gw);
		AddSpaceStationButton.setCommand(addSpaceStationCommand);
		addKeyListener('b', addSpaceStationCommand);
		leftContainer.add(AddSpaceStationButton);
		
		//Add Missiles
		Button reloadMissilesButton = new Button("Reload Missiles");
		reloadMissilesButton.getAllStyles().setBgTransparency(255);
		reloadMissilesButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		reloadMissilesButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		reloadMissilesButton.getAllStyles().setPadding(TOP, 1);
		reloadMissilesButton.getAllStyles().setPadding(BOTTOM, 1);
		reloadMissilesButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		ReloadMissilesCommand reloadMissilesCommand = new ReloadMissilesCommand(gw);
		reloadMissilesButton.setCommand(reloadMissilesCommand);
		addKeyListener('n', reloadMissilesCommand);
		leftContainer.add(reloadMissilesButton);
		
		//Move Button
		Button MoveButton = new Button("Move");
		MoveButton.getAllStyles().setBgTransparency(255);
		MoveButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		MoveButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		MoveButton.getAllStyles().setPadding(TOP, 1);
		MoveButton.getAllStyles().setPadding(BOTTOM, 1);
		MoveButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		MoveCommand moveCommand = new MoveCommand(gw);
		MoveButton.setCommand(moveCommand);
		addKeyListener('t', moveCommand);
		leftContainer.add(MoveButton);
		
		//Hyper Space Button
		Button HyperSpaceButton = new Button("Hyper Space!");
		HyperSpaceButton.getAllStyles().setBgTransparency(255);
		HyperSpaceButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		HyperSpaceButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		HyperSpaceButton.getAllStyles().setPadding(TOP, 1);
		HyperSpaceButton.getAllStyles().setPadding(BOTTOM, 1);
		HyperSpaceButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		HyperSpaceCommand HyperSpaceCommand = new HyperSpaceCommand(gw);
		HyperSpaceButton.setCommand(HyperSpaceCommand);
		addKeyListener('j', HyperSpaceCommand);
		leftContainer.add(HyperSpaceButton);
		
		//Increase speed Button
		Button IncreaseSpeedButton = new Button("Increase Speed");
		IncreaseSpeedButton.getAllStyles().setBgTransparency(255);
		IncreaseSpeedButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		IncreaseSpeedButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		IncreaseSpeedButton.getAllStyles().setPadding(TOP, 1);
		IncreaseSpeedButton.getAllStyles().setPadding(BOTTOM, 1);
		IncreaseSpeedButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		IncreaseSpeedCommand IncreaseSpeedCommand = new IncreaseSpeedCommand(gw);
		IncreaseSpeedButton.setCommand(IncreaseSpeedCommand);
		addKeyListener('i', IncreaseSpeedCommand);
		leftContainer.add(IncreaseSpeedButton);
		
		//Decrease speed Button
		Button DecreaseSpeedButton = new Button("Decrease Speed");
		DecreaseSpeedButton.getAllStyles().setBgTransparency(255);
		DecreaseSpeedButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		DecreaseSpeedButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		DecreaseSpeedButton.getAllStyles().setPadding(TOP, 1);
		DecreaseSpeedButton.getAllStyles().setPadding(BOTTOM, 1);
		DecreaseSpeedButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		DecreaseSpeedCommand DecreaseSpeedCommand = new DecreaseSpeedCommand(gw);
		DecreaseSpeedButton.setCommand(DecreaseSpeedCommand);
		addKeyListener('d', DecreaseSpeedCommand);
		leftContainer.add(DecreaseSpeedButton);
		
		//change ship left direction Button
		Button ChangeDirectionLeftButton = new Button("Change Player Direction Left");
		ChangeDirectionLeftButton.getAllStyles().setBgTransparency(255);
		ChangeDirectionLeftButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		ChangeDirectionLeftButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		ChangeDirectionLeftButton.getAllStyles().setPadding(TOP, 1);
		ChangeDirectionLeftButton.getAllStyles().setPadding(BOTTOM, 1);
		ChangeDirectionLeftButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		ChangeDirectionLeftCommand ChangeDirectionLeftCommand = new ChangeDirectionLeftCommand(gw);
		ChangeDirectionLeftButton.setCommand(ChangeDirectionLeftCommand);
		addKeyListener('l', ChangeDirectionLeftCommand);
		leftContainer.add(ChangeDirectionLeftButton);

		//change ship right direction Button
		Button ChangeDirectionRightButton = new Button("Change Player Direction Right");
		ChangeDirectionRightButton.getAllStyles().setBgTransparency(255);
		ChangeDirectionRightButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		ChangeDirectionRightButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		ChangeDirectionRightButton.getAllStyles().setPadding(TOP, 1);
		ChangeDirectionRightButton.getAllStyles().setPadding(BOTTOM, 1);
		ChangeDirectionRightButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		ChangeDirectionRightCommand ChangeDirectionRightCommand = new ChangeDirectionRightCommand(gw);
		ChangeDirectionRightButton.setCommand(ChangeDirectionRightCommand);
		addKeyListener('r', ChangeDirectionRightCommand);
		leftContainer.add(ChangeDirectionRightButton);
		
		//change Player Ship Launcher left direction Button
		Button ChangeLauncherDirectionLeftButton = new Button("Change Launcher Direction Left");
		ChangeLauncherDirectionLeftButton.getAllStyles().setBgTransparency(255);
		ChangeLauncherDirectionLeftButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		ChangeLauncherDirectionLeftButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		ChangeLauncherDirectionLeftButton.getAllStyles().setPadding(TOP, 1);
		ChangeLauncherDirectionLeftButton.getAllStyles().setPadding(BOTTOM, 1);
		ChangeLauncherDirectionLeftButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		ChangeLauncherDirectionLeftCommand ChangeLauncherDirectionLeftCommand = new ChangeLauncherDirectionLeftCommand(gw);
		ChangeLauncherDirectionLeftButton.setCommand(ChangeLauncherDirectionLeftCommand);
		addKeyListener(44, ChangeLauncherDirectionLeftCommand);
		leftContainer.add(ChangeLauncherDirectionLeftButton);
		
		//change Player Ship Launcher right direction Button
		Button ChangeLauncherDirectionRightButton = new Button("Change Launcher Direction Right");
		ChangeLauncherDirectionRightButton.getAllStyles().setBgTransparency(255);
		ChangeLauncherDirectionRightButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		ChangeLauncherDirectionRightButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		ChangeLauncherDirectionRightButton.getAllStyles().setPadding(TOP, 1);
		ChangeLauncherDirectionRightButton.getAllStyles().setPadding(BOTTOM, 1);
		ChangeLauncherDirectionRightButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		ChangeLauncherDirectionRightCommand ChangeLauncherDirectionRightCommand = new ChangeLauncherDirectionRightCommand(gw);
		ChangeLauncherDirectionRightButton.setCommand(ChangeLauncherDirectionRightCommand);
		addKeyListener(44, ChangeLauncherDirectionRightCommand);
		leftContainer.add(ChangeLauncherDirectionRightButton);
		
		//Fire Player Missile
		Button FirePlayerMissileButton = new Button("Fire!");
		FirePlayerMissileButton.getAllStyles().setBgTransparency(255);
		FirePlayerMissileButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		FirePlayerMissileButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		FirePlayerMissileButton.getAllStyles().setPadding(TOP, 1);
		FirePlayerMissileButton.getAllStyles().setPadding(BOTTOM, 1);
		FirePlayerMissileButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		FirePlayerMissileCommand FirePlayerMissileCommand = new FirePlayerMissileCommand(gw);
		FirePlayerMissileButton.setCommand(FirePlayerMissileCommand);
		addKeyListener(-90, FirePlayerMissileCommand);
		addKeyListener('f', FirePlayerMissileCommand);
		leftContainer.add(FirePlayerMissileButton);
		
		//Fire Missile
		Button FireMissileButton = new Button("Enemy Fire!");
		FireMissileButton.getAllStyles().setBgTransparency(255);
		FireMissileButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		FireMissileButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		FireMissileButton.getAllStyles().setPadding(TOP, 1);
		FireMissileButton.getAllStyles().setPadding(BOTTOM, 1);
		FireMissileButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		FireMissileCommand FireMissileCommand = new FireMissileCommand(gw);
		FireMissileButton.setCommand(FireMissileCommand);
		addKeyListener('L', FireMissileCommand);
		leftContainer.add(FireMissileButton);
		
		//Crash Asteroid
		Button CrashAsteroidsButton = new Button("Crash Asteroids");
		CrashAsteroidsButton.getAllStyles().setBgTransparency(255);
		CrashAsteroidsButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		CrashAsteroidsButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		CrashAsteroidsButton.getAllStyles().setPadding(TOP, 1);
		CrashAsteroidsButton.getAllStyles().setPadding(BOTTOM, 1);
		CrashAsteroidsButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		CrashAsteroidsCommand crashAsteroidsCommand = new CrashAsteroidsCommand(gw);
		CrashAsteroidsButton.setCommand(crashAsteroidsCommand);
		addKeyListener('x', crashAsteroidsCommand);
		leftContainer.add(CrashAsteroidsButton);
		
		//Blast asteroid
		Button BlastAsteroidButton = new Button("Blast Asteroid");
		BlastAsteroidButton.getAllStyles().setBgTransparency(255);
		BlastAsteroidButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		BlastAsteroidButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		BlastAsteroidButton.getAllStyles().setPadding(TOP, 1);
		BlastAsteroidButton.getAllStyles().setPadding(BOTTOM, 1);
		BlastAsteroidButton.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		BlastAsteroidCommand blastAsteroidCommand = new BlastAsteroidCommand(gw);
		BlastAsteroidButton.setCommand(blastAsteroidCommand);
		addKeyListener('k', blastAsteroidCommand);
		leftContainer.add(BlastAsteroidButton);
		
		//Crash Player into Asteroid
		Button plyrCrshAstr = new Button("Player Crash into Asteroid");
		plyrCrshAstr.getAllStyles().setBgTransparency(255);
		plyrCrshAstr.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		plyrCrshAstr.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		plyrCrshAstr.getAllStyles().setPadding(TOP, 1);
		plyrCrshAstr.getAllStyles().setPadding(BOTTOM, 1);
		plyrCrshAstr.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		PlayerCrashAsteroidCommand plyrCrshAstrCommand = new PlayerCrashAsteroidCommand(gw);
		plyrCrshAstr.setCommand(plyrCrshAstrCommand);
		addKeyListener('c', plyrCrshAstrCommand);
		leftContainer.add(plyrCrshAstr);
		
		//Asteroid Destroyed by Missile
		Button AstrMissileDestroy = new Button("Asteroid Destroyed by Missile");
		AstrMissileDestroy.getAllStyles().setBgTransparency(255);
		AstrMissileDestroy.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		AstrMissileDestroy.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		AstrMissileDestroy.getAllStyles().setPadding(TOP, 1);
		AstrMissileDestroy.getAllStyles().setPadding(BOTTOM, 1);
		AstrMissileDestroy.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		AsteroidMissileDestroyCommand AstrMissileDestroyCommand = new AsteroidMissileDestroyCommand(gw);
		AstrMissileDestroy.setCommand(AstrMissileDestroyCommand);
		addKeyListener('k', AstrMissileDestroyCommand);
		leftContainer.add(AstrMissileDestroy);
		
		//NPS Destroyed by Missile
		Button NPSMissileDestroy = new Button("NonPlayer Destroyed by Missile");
		NPSMissileDestroy.getAllStyles().setBgTransparency(255);
		NPSMissileDestroy.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		NPSMissileDestroy.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		NPSMissileDestroy.getAllStyles().setPadding(TOP, 1);
		NPSMissileDestroy.getAllStyles().setPadding(BOTTOM, 1);
		NPSMissileDestroy.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		NPSMissileDestroyCommand NPSMissileDestroyCommand = new NPSMissileDestroyCommand(gw);
		NPSMissileDestroy.setCommand(NPSMissileDestroyCommand);
		addKeyListener('e', NPSMissileDestroyCommand);
		leftContainer.add(NPSMissileDestroy);
		
		//NPS Destroyed by Missile
		Button PlayerMissileDestroy = new Button("Player Destroyed by Missile");
		PlayerMissileDestroy.getAllStyles().setBgTransparency(255);
		PlayerMissileDestroy.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		PlayerMissileDestroy.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		PlayerMissileDestroy.getAllStyles().setPadding(TOP, 1);
		PlayerMissileDestroy.getAllStyles().setPadding(BOTTOM, 1);
		PlayerMissileDestroy.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		PlayerMissileDestroyCommand PlayerMissileDestroyCommand = new PlayerMissileDestroyCommand(gw);
		PlayerMissileDestroy.setCommand(PlayerMissileDestroyCommand);
		addKeyListener('E', PlayerMissileDestroyCommand);
		leftContainer.add(PlayerMissileDestroy);
		
		//NPS Destroyed by Asteroid
		Button NPSAsteroidCrash = new Button("NonPlayer crash into Asteroid");
		NPSAsteroidCrash.getAllStyles().setBgTransparency(255);
		NPSAsteroidCrash.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		NPSAsteroidCrash.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		NPSAsteroidCrash.getAllStyles().setPadding(TOP, 1);
		NPSAsteroidCrash.getAllStyles().setPadding(BOTTOM, 1);
		NPSAsteroidCrash.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		NPSAsteroidCrashCommand NPSAsteroidCrashCommand = new NPSAsteroidCrashCommand(gw);
		NPSAsteroidCrash.setCommand(NPSAsteroidCrashCommand);
		addKeyListener('I', NPSAsteroidCrashCommand);
		leftContainer.add(NPSAsteroidCrash);
		
		//NPS and Player Crash
		Button NPSPlayerCrash = new Button("NonPlayer crash into Player");
		NPSPlayerCrash.getAllStyles().setBgTransparency(255);
		NPSPlayerCrash.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		NPSPlayerCrash.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		NPSPlayerCrash.getAllStyles().setPadding(TOP, 1);
		NPSPlayerCrash.getAllStyles().setPadding(BOTTOM, 1);
		NPSPlayerCrash.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		NPSPlayerCrashCommand NPSPlayerCrashCommand = new NPSPlayerCrashCommand(gw);
		NPSPlayerCrash.setCommand(NPSPlayerCrashCommand);
		addKeyListener('h', NPSPlayerCrashCommand);
		leftContainer.add(NPSPlayerCrash);
		
		//display All Objects
		Button displayCollection = new Button("Display objects");
		displayCollection.getAllStyles().setBgTransparency(255);
		displayCollection.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 75, 150));
		displayCollection.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		displayCollection.getAllStyles().setPadding(TOP, 1);
		displayCollection.getAllStyles().setPadding(BOTTOM, 1);
		displayCollection.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		DisplayCollectionCommand displayCollectionCommand = new DisplayCollectionCommand(gw);
		displayCollection.setCommand(displayCollectionCommand);
		addKeyListener('m',displayCollectionCommand);
		leftContainer.add(displayCollection);
		
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLACK));
		add(BorderLayout.WEST,leftContainer);
	}
	private void setCenter() {
		Container centerContainer = new Container();
		centerContainer.add(mv);
		centerContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.rgb(0,100,150)));
		add(BorderLayout.CENTER,centerContainer);
	}

}
