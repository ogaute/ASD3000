package controller;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import easylib.controller.SuperAction;
import easylib.controller.Usecase;

/**
 * ARedo klassen har ansvar får å sette forklaringstekst og håndtere hendelsen
 */
public class ARedo extends SuperAction {
    /**
     * Bruker eksternt klasse fra easylib
     * @param usecase Usecase fra easylib
     */
	ARedo(Usecase usecase){
		super(usecase);
		putValue(Action.SHORT_DESCRIPTION, "Gå fremover");
		putValue(Action.LONG_DESCRIPTION, "Nå kan du gå fremover");
	}

    /**
     * Sender melding videre til Controller
     * @param e
     */
	public void actionPerformed(ActionEvent e) {
		Controller.redoMove();
	}
}
