/*
 * Created on 24.mai.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package gui;

import controller.Controller;
import easylib.gui.MMenu;

import javax.swing.*;
/**
 * Denne klassen har ansvar for å Lage menyelementer og  Sette tilstand på menyvalg.
 */
public class MenuController extends JMenuBar {

    private boolean undoEnable;

    /**
     * Konstruktøren som instansierer flere MMenu objekter.
     */
    public MenuController() {
		MMenu file = new MMenu("Fil");
		MMenu help = new MMenu("Hjelp");
        MMenu edit = new MMenu("Edit");

		file.add(Controller.aexit);
	
		help.add(Controller.aabout);


        edit.add(Controller.actionredo);
        edit.add(Controller.actionundo);

		add(file);
        add(edit);
		add(help);
	}

    /**
     *
     * @param undoEnable boolean verdi for å sette undo meny elementet til aktivt eller innaktivt
     */
    public void setUndoEnable(boolean undoEnable) {
        this.undoEnable = undoEnable;
    }

    /**
     *
     * @return returnerer boolean verdien slik at man kan sette Undo menyelemetet til aktiv eller innaktiv.
     */
    public boolean isUndoEnable() {
        return undoEnable;
    }
}
