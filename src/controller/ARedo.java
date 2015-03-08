package controller;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import easylib.controller.SuperAction;
import easylib.controller.Usecase;

/**
 * ARedo klassen har ansvar får å sette forklaringstekst og håndtere hendelsen
 * 
 * Klassen bruker Chain of Responsibility mønsteret.
 */
public class ARedo extends SuperAction {
	
	
    /**
     * Setter beskrivelse<p>
     * Bruker eksternt klasse, Usecase, fra easylib
     * @param usecase Tar et Usecase objekt som innparameter
     */
	ARedo(Usecase usecase){
		super(usecase);
		putValue(Action.SHORT_DESCRIPTION, "Gå fremover");
		putValue(Action.LONG_DESCRIPTION, "Nå kan du gå fremover");
	}

    /**
     * Sender melding videre til Controller
     * @param e Tar et ActionEvent objekt som innparameter
     */
	public void actionPerformed(ActionEvent e) {
		Controller.redoMove();
	}
	
	
}
