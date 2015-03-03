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


	public ApplicationFrame() {
		Controller.init(this);
		setTitle("Chessgame");
		setLayout(new BorderLayout());
		add(centerpane = new Centerpane());
		setJMenuBar(new MenuController());
		setLocationByPlatform(true);
		setSize(800,800);
		setVisible(true);
		setResizable(false);
    }

	public void exit() {
		System.exit(0);
	}

    @Override
    public void setStatustext(String s) {
        // FRA easylib
    }

    public void about() {
        JOptionPane.showMessageDialog(this, "Chessie 1.0 RC Client");
	}

    @Override
	public void repaint() {
		super.repaint();
	}

    // CoR meldingsstier
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
