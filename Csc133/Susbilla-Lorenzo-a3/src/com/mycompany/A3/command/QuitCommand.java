package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.A3.GameWorld;

public class QuitCommand extends Command {
	
	private GameWorld gw;
	public QuitCommand(GameWorld gw) {
		super("Quit");
		this.gw = gw;
		
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed (ActionEvent e) {
		  Boolean bOk = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");
		    if (bOk){
			         Display.getInstance().exitApplication();
		    }
	}


}
