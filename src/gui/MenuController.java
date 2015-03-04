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

	public MenuController() {
		// Horisontal meny elements
		MMenu file = new MMenu("Fil");
		MMenu help = new MMenu("Hjelp");

		// vertical file menu elements
		file.add(Controller.aexit);
	
		// vertical help menu elements
		help.add(Controller.aabout);

		// fix vertical menu elements to this horizontal bar
		add(file);		
		add(help);
	}

}
