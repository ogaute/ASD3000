package gui;

import controller.Controller;
import easylib.controller.ISupercontroller;

import javax.swing.*;

import java.awt.*;

public class ApplicationFrame extends JFrame implements ISupercontroller {


	private Centerpane centerpane = null;
	private Eastpane eastpane = null;
    private MenuController menuController;

    /**
     *
     */
	public ApplicationFrame() {
		Controller.init(this);
		setTitle("Chessie");
		setLayout(new BorderLayout());
		add(eastpane = new Eastpane(), BorderLayout.EAST);
		add(centerpane = new Centerpane(), BorderLayout.CENTER);
		setJMenuBar(menuController = new MenuController());
		setLocationByPlatform(true);
		setSize(1000,800);
		setVisible(true);
		setResizable(false);
    }

    /**
     *
     */
	public void exit() {
		System.exit(0);
	}

    /***
     *
     * @param s
     */
    @Override
    public void setStatustext(String s) {
        // FRA easylib
    }

    /**
     *
     */
    public void about() {
        JOptionPane.showMessageDialog(this, "Chessie 1.1 RC Client");
	}

    /**
     * CoR meldingsstier
     * @param column
     * @param row
     * @return
     */
    public boolean canIMoveTo(int column, int row) {
		return centerpane.canIMoveTo(column, row);
	}

    /**
     * CoR meldingsstier
     */
	public void resetSquares() {
		centerpane.resetSquares();
	}

    /**
     * CoR meldingsstier
     * @param column
     * @param row
     */
	public void moveTo(int column, int row) {
		centerpane.moveTo(column, row);
	}

    /**
     * CoR meldingsstier
     * @param column
     * @param row
     */
	public void setLastPressed(int column, int row) {
		centerpane.setLastPressed(column, row);
	}

    /**
     * CoR meldingsstier
     */
	public void changePlayerInTurn() {
		centerpane.changePlayerInTurn();
	}

    /**
     * CoR meldingsstier
     * @return
     */
	public String getPlayerInTurn() {
		return centerpane.getPlayerInTurn();
	}

    /**
     * CoR meldingsstier
     * @param toColumn
     * @param toRow
     * @return
     */
	public boolean canICapture(int toColumn, int toRow) {
		return centerpane.canICapture(toColumn, toRow);
	}

    /**
     * CoR meldingsstier
     */
	public void checkMate() {
		new GameOverDialog(this);
	}

    /**
     * CoR meldingsstier
     * @return
     */
	public String whoWon() {
		return centerpane.whoWon();
	}

    /**
     * CoR meldingsstier
     */
	public void undoMove() {
		centerpane.undoMove();
	}

    /**
     * CoR meldingsstier
     * @param b
     */
	public void setUndoEnable(boolean b) {
        eastpane.setUndoEnable(b);
	}

    /**
     * CoR meldingsstier
     * @param b
     */
	public void setRedoEnable(boolean b) {
		eastpane.setRedoEnable(b);
    }

    /**
     * CoR meldingsstier
     */
	public void redoMove() {
		centerpane.redoMove();
	}

    /**
     * CoR meldingsstier
     * @param fen
     */
    public void addFenInfo(String fen) {
        eastpane.addFenInfo(fen);
    }

    /**
     * CoR meldingsstier
     * @return
     */
    public String promotionDialog() {
        return new PromotionDialog().makePromotionWindow(this);

    }
}
