package gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Centerpane extends JPanel {

	public Centerpane() {
		setLayout(new BorderLayout());
		add(new ChessBoard());
		
	}


}
