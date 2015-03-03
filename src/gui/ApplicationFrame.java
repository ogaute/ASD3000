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
		//setLocationRelativeTo(null);
		setLocationByPlatform(true);
		setSize(1000,800);
		setVisible(true);
		//System.out.println(" La til denne for å teste ");
		setResizable(false);
		
	    /*addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentResized(ComponentEvent e) {
	        //System.out.println("Reseized");
	        //repaint();
	        setSize(getSize().width, getSize().width);
	      }
	    });*/
		
		
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

	public boolean canIMoveTo(int column, int row) {
		return centerpane.canIMoveTo(column, row);
	}

	public void resetSquares() {
		centerpane.resetSquares();
	}

	public void moveTo(int column, int row) {
		centerpane.moveTo(column, row);
	}

	public void setLastPressed(int column, int row) {
		centerpane.setLastPressed(column, row);
	}

	public void changePlayerInTurn() {
		centerpane.changePlayerInTurn();
	}

	public String getPlayerInTurn() {
		return centerpane.getPlayerInTurn();
	}

	public boolean canICapture(int toColumn, int toRow) {
		return centerpane.canICapture(toColumn, toRow);
	}

}
