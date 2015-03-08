package controller;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import easylib.controller.SuperAction;
import easylib.controller.Usecase;

/**
 * AUndo klassen har ansvar får å sette forklaringstekst og håndtere hendelsen
 */
public class AUndo extends SuperAction {

    /**
     *
     * @param usecase Usecase
     */
	AUndo(Usecase usecase) {
		super(usecase);
		putValue(Action.SHORT_DESCRIPTION, "Gå tilbake");
		putValue(Action.LONG_DESCRIPTION, "Nå kan du gå tilbake");
	}

    /**
     * Sender melding videre til Controller
     * @param e
     */
	public void actionPerformed(ActionEvent e) {
		Controller.undoMove();
	}

	
}
