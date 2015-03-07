package controller;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import easylib.controller.SuperAction;
import easylib.controller.Usecase;

public class AUndo extends SuperAction {

    /**
     *
     * @param usecase
     */
	AUndo(Usecase usecase) {
		super(usecase);
		putValue(Action.SHORT_DESCRIPTION, "Gå tilbake");
		putValue(Action.LONG_DESCRIPTION, "Nå kan du gå tilbake");
	}

    /**
     *
     * @param e
     */
	public void actionPerformed(ActionEvent e) {
		Controller.undoMove();
	}

	
}
