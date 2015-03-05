package controller;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import easylib.controller.SuperAction;
import easylib.controller.Usecase;

public class ARedo extends SuperAction {

	ARedo(Usecase usecase){
		super(usecase);
		putValue(Action.SHORT_DESCRIPTION, "Gå fremover");
		putValue(Action.LONG_DESCRIPTION, "Nå kan du gå fremover");
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("redo");
		Controller.redoMove();
	}
}
