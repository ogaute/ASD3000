package controller;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import easylib.controller.SuperAction;
import easylib.controller.Usecase;

/**
 * AUndo klassen har ansvar får å sette forklaringstekst og håndtere hendelsen.
 * 
 * Klassen bruker Chain of Responsibility mønsteret.
 */
public class AUndo extends SuperAction {

	
    /**
     * Setter beskrivelse<p>
     * Bruker eksternt klasse, Usecase, fra easylib
     * 
     * @param usecase Tar et Usecase-objekt som innparameter
     */
	AUndo(Usecase usecase) {
		super(usecase);
		putValue(Action.SHORT_DESCRIPTION, "Gå ett trekk tilbake");
		putValue(Action.LONG_DESCRIPTION, "Du kan gå ett trekk tilbake");
	}

    /**
     * Sender melding videre til Controller
     * 
     * @param e Tar et ActionEvent-objekt som innparameter
     */
	public void actionPerformed(ActionEvent e) {
		Controller.undoMove();
	}

	
}
