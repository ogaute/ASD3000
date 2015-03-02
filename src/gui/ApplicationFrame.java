package gui;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
		//System.out.println(" La til denne for å teste ");
		
	    addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentResized(ComponentEvent e) {
	        System.out.println("Reseized");
	        //repaint();
	        setSize(getSize().width, getSize().width);
	      }
	    });
		
		
	}

	public void exit() {
		System.exit(0);
	}

	public void about() {
		JOptionPane.showMessageDialog(this, "Chessgame 0.1");
	}

	public void setStatustext(String s) {
		// TODO Auto-generated method stub
		// Dette er Application Som trenger ett l�ft
		// mERE mErEW mmERE
	}

	
	@Override
	public void repaint() {
		super.repaint();
		//setSize(getSize().width, getSize().width);
	}
	
	public StockFishInfo getSFI(){
		return eastpane.getSFI();
	}

}
