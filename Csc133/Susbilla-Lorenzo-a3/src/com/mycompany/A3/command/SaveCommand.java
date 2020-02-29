package com.mycompany.A3.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SaveCommand extends Command {

	public SaveCommand() {
		super("Save");
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed (ActionEvent e) {
		System.out.println("save successful");
	}
}
