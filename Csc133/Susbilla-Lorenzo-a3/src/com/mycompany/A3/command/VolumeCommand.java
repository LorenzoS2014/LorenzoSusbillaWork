package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.BGSound;
import com.mycompany.A3.GameWorld;

public class VolumeCommand extends Command{
	private GameWorld gw;
	private BGSound bgSound;
	public VolumeCommand(GameWorld gw) {
		super("Mute");
		this.gw = gw;
		bgSound = new BGSound("Space Ship Bridge Loop.wav");
		bgSound.play();
	}
	public void actionPerformed (ActionEvent e) {
		gw.setSoundflag();
		if (gw.getSoundFlag())
			bgSound.pause();
		else
			bgSound.play();
	}

}
