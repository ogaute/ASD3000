package controller;

import easylib.controller.SuperAction;
import easylib.controller.Usecase;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class AStart  extends SuperAction {


    public AStart(Usecase usecase) {
        super(usecase);
        putValue(Action.SHORT_DESCRIPTION, "Nytt spill");
        putValue(Action.LONG_DESCRIPTION, "Start spillet på nytt ");
    }


    /**
     * Sender melding videre til Controller
     * @param e Tar et ActionEvent-objekt som innparameter
     */
    public void actionPerformed(ActionEvent e) {
        Controller.newGame();
    }
}
