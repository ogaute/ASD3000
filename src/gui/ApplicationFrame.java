package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;
import easylib.controller.ISupercontroller;

public class ApplicationFrame extends JFrame implements ISupercontroller {

	private Centerpane centerpane = null;
	private Southpane southpane = null;
	private Eastpane eastpane = null;

	public ApplicationFrame() {
		Controller.init(this);
		setTitle("Chessgame");
		setLayout(new BorderLayout());
		add(centerpane = new Centerpane(), BorderLayout.CENTER);
		add(southpane = new Southpane(), BorderLayout.SOUTH);
		add(eastpane = new Eastpane(), BorderLayout.EAST);
		setJMenuBar(new MenuController());
		setLocationRelativeTo(null);
		setSize(800,800);
		setVisible(true);
		
	}

	public void exit() {
		System.exit(0);
	}

	public void about() {
		JOptionPane.showMessageDialog(this, "Chessgame 0.1");
	}

	public void setStatustext(String s) {
		// TODO Auto-generated method stub
		
	}


}
