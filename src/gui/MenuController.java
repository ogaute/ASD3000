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

public class MenuController extends JMenuBar {

    private boolean undoEnable;

    public MenuController() {
		// Horisontal meny elements
		MMenu file = new MMenu("Fil");
		MMenu help = new MMenu("Hjelp");
        MMenu edit = new MMenu("Edit");

		// vertical file menu elements
		file.add(Controller.aexit);
	
		// vertical help menu elements
		help.add(Controller.aabout);


        // vertikal edit menu elementer
        edit.add(Controller.actionredo);
        edit.add(Controller.actionundo);

		// fix vertical menu elements to this horizontal bar
		add(file);
        add(edit);
		add(help);
	}


    public void setUndoEnable(boolean undoEnable) {
        this.undoEnable = undoEnable;
    }

    public boolean isUndoEnable() {
        return undoEnable;
    }
}
