package controller;

import easylib.controller.ISupercontroller;
import easylib.controller.SuperAction;
import easylib.controller.Supercontroller;
import gui.ApplicationFrame;
import logic.OutOfBoardFilter;

/**
 * Klassen Controller har ansvar for å sende meldinger videre i systemet.
 * 
 * Klassens implementering muliggjør bruk av mønsteret Chain of Responsibility - CoR.
 */

public class Controller extends Supercontroller implements IActionlist {

	
	public static SuperAction actionundo;
	public static SuperAction actionredo;

    /**
     * 
     * 
     * @param frame
     */
	public static void init(ISupercontroller frame) {
		superinit(frame);
		actionundo = new AUndo(UNDO);
		actionredo = new ARedo(REDO);
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     */
	public static void exit() {
		ui.exit();
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til OutOfBoardFilter og ApplicationFrame
     * 
     * @param column Kolonne på spillebrettet
     * @param row Rad på spillebrettet
     * @return
     */
	public static boolean canIMoveTo(int column, int row) {
        return !OutOfBoardFilter.isOutOfBoard(column, row) && ((ApplicationFrame) ui).canIMoveTo(column, row);
    }

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame<p>
     */
	public static void resetSquares() {
		((ApplicationFrame)ui).resetSquares();
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til OutOfBoardFilter, og dersom feltet ikke
     * er utenfor brettet, så sendes melding videre til ApplicationFrame
     * 
     * @param column Kolonne på spillebrettet
     * @param row Rad på spillebrettet
     */
	public static void moveTo(int column, int row) {
		if(!OutOfBoardFilter.isOutOfBoard(column, row))
			((ApplicationFrame)ui).moveTo(column, row);
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     * 
     * @param column Kolonne på spillebrettet
     * @param row Rad på spillebrettet
     */
	public static void setLastPressed(int column, int row) {
		((ApplicationFrame)ui).setLastPressed(column, row);
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     */
	public static void changePlayerInTurn() {
		((ApplicationFrame)ui).changePlayerInTurn();
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     * @return Returnerer hvilken spiller som har tur
     */
	public static String getPlayerInTurn() {
		return ((ApplicationFrame)ui).getPlayerInTurn();
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til OutOfBoardFilter og ApplicationFrame
     * @param toColumn Kolonne man ønsker sjekke
     * @param toRow Rad man ønsker å sjekke
     * @return Returnerer true eller false
     */
	public static boolean canICapture(int toColumn, int toRow) {
        return !OutOfBoardFilter.isOutOfBoard(toColumn, toRow) && ((ApplicationFrame) ui).canICapture(toColumn, toRow);
    }

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     */
	public static void checkMate() {
		((ApplicationFrame)ui).checkMate();
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     * @return Returnerer hvilken spiller som vant
     */
	public static String whoWon() {
		return ((ApplicationFrame)ui).whoWon();
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     */
	public static void undoMove() {
		((ApplicationFrame)ui).undoMove();
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     * @param b boolean verdi for å sette setEnable til true eller false
     */
	public static void setUndoEnable(boolean b) {
		((ApplicationFrame)ui).setUndoEnable(b);
        actionundo.setEnabled(b);
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     * @param b boolean verdi for å sette setEnable til true eller false
     */
	public static void setRedoEnable(boolean b) {
		((ApplicationFrame)ui).setRedoEnable(b);
        actionredo.setEnabled(b);
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     */
	public static void redoMove() {
		((ApplicationFrame)ui).redoMove();
	}

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     * @param fen En string med FEN-notasjon
     */
    public static void addLegalMovesInfo(String fen) {
        ((ApplicationFrame)ui).addLegalMovesInfo(fen);
    }

    /**
     * CoR meldingssti<p>
     * Sender melding videre til ApplicationFrame
     * @return
     */
    public static String promotionDialog() {
        return ((ApplicationFrame)ui).promotionDialog();

    }
    
    
}
