package gui;

import controller.Controller;
import easylib.controller.ISupercontroller;

import javax.swing.*;

import java.awt.*;

/**
 * ApplicationFrame har ansvar for å lage brukergrensesnittelementer i applikasjonen. <p>
 * ApplicationFrame har også ansvar for å sende meldinger vidre i systemet og agreggere <p>
 * flere objekter.
 */
public class ApplicationFrame extends JFrame implements ISupercontroller {


	private Centerpane centerpane = null;
	private Eastpane eastpane = null;
    private MenuController menuController;

    /**
     *Konstruktøren for denne klassen. legger til paneler, meny linje og setter <p>
     *lokasjonene på vinduet.
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
     * Metode som avslutter applikasjonen.
     */
	public void exit() {
		System.exit(0);
	}

    /***
     * fra easylib.....
     * @param s
     */
    @Override
    public void setStatustext(String s) {
    }

    /**
     * Metode som starter en dialogboks som viser litt informasjon om applikasjonen
     */
    public void about() {
        JOptionPane.showMessageDialog(this, "Chessie 1.1 RC Client" +"\n" +"\n" +
                "Laget av : " +"\n" +
                "Andrea Bøe Abrahamsen, " +"\n" +
                "Anders Borg Larsen, "  +"\n" +
                "Linda Fermann, "  +"\n" +
                "Øyvind Gatestad");
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
     * @param column kolonne man flytter til
     * @param row rad man flytter til
     */
	public void moveTo(int column, int row) {
		centerpane.moveTo(column, row);
	}

    /**
     * CoR meldingsstier
     * @param column kolonnen på sist trykket
     * @param row raden på sist trykket
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
     * @return spiller som har sin tur.
     */
	public String getPlayerInTurn() {
		return centerpane.getPlayerInTurn();
	}

    /**
     * CoR meldingsstier
     * @param toColumn kolonnen der man kan fange en brikke
     * @param toRow raden der man kan fange en brikke
     * @return sender tilbake hilken kolone og rad man kan fange
     */
	public boolean canICapture(int toColumn, int toRow) {
		return centerpane.canICapture(toColumn, toRow);
	}

    /**
     * CoR meldingsstier
     * Hvis sjakk matt oppstår Instansieres GameOverDialog vinduet
     */
	public void checkMate() {
		new GameOverDialog(this);
	}

    /**
     * CoR meldingsstier
     * @return returnerer hvem som har vunnet spillet
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
     */
    public void redoMove() {
        centerpane.redoMove();
    }

    /**
     * CoR meldingsstier
     * @param b boolean for å sette knappen til Undo aktiv eller inaktiv.
     */
	public void setUndoEnable(boolean b) {
        eastpane.setUndoEnable(b);
	}

    /**
     * CoR meldingsstier
     * @param b boolean for å sette knappen til Redo aktiv eller inaktiv.
     */
	public void setRedoEnable(boolean b) {
		eastpane.setRedoEnable(b);
    }



    /**
     * CoR meldingsstier
     * @param fen Tekst streng som blir brukt til utskrift i eastpanel
     */
    public void addFenInfo(String fen) {
        eastpane.addFenInfo(fen);
    }

    /**
     * CoR meldingsstier
     * Innstansierer et nytt Dialogvindu  av typen PromotionDialog .Der man kan forfremme brikker.
     * @return
     */
    public String promotionDialog() {
        return new PromotionDialog().makePromotionWindow(this);

    }
}
