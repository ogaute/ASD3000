package controller;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import easylib.controller.SuperAction;
import easylib.controller.Usecase;

public class ARedo extends SuperAction {
    /**
     *
     * @param usecase
     */
	ARedo(Usecase usecase){
		super(usecase);
		putValue(Action.SHORT_DESCRIPTION, "Gå fremover");
		putValue(Action.LONG_DESCRIPTION, "Nå kan du gå fremover");
	}

    /**
     * 
     * @param e
     */
	public void actionPerformed(ActionEvent e) {
		Controller.redoMove();
	}
}
