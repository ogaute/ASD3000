package gui;

import controller.Controller;
import easylib.controller.ISupercontroller;

import javax.swing.*;

import java.awt.*;

public class ApplicationFrame extends JFrame implements ISupercontroller {


	private Centerpane centerpane = null;
	private Eastpane eastpane = null;

	public ApplicationFrame() {
		Controller.init(this);
		setTitle("Chessgame");
		setLayout(new BorderLayout());
		add(eastpane = new Eastpane(), BorderLayout.EAST);
		add(centerpane = new Centerpane(), BorderLayout.CENTER);
		setJMenuBar(new MenuController());
		setLocationByPlatform(true);
		setSize(1000,800);
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

	public void checkMate() {
		new GameOverDialog(this);
	}

	public String whoWon() {
		return centerpane.whoWon();
	}

	public void undoMove() {
		centerpane.undoMove();
	}

	public void setUndoEnable(boolean b) {
		eastpane.setUndoEnable(b);
	}

	public void setRedoEnable(boolean b) {
		eastpane.setRedoEnable(b);
	}

	public void redoMove() {
		centerpane.redoMove();
	}
	

}
