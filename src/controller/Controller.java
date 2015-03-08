package controller;

import easylib.controller.ISupercontroller;
import easylib.controller.SuperAction;
import easylib.controller.Supercontroller;
import gui.ApplicationFrame;
import logic.OutOfBoardFilter;

/**
 * Klassen Controller har ansvar for å sende meldinger i sytemet.
 */
public class Controller extends Supercontroller implements IActionlist {

	public static SuperAction actionundo;
	public static SuperAction actionredo;

    /**
     *
     * @param frame
     */
	public static void init(ISupercontroller frame) {
		superinit(frame);
		actionundo = new AUndo(UNDO);
		actionredo = new ARedo(REDO);
	}

    /**
     * CoR meldingsstier<p>
     *Sender melding videre til Application frame
     */
	public static void exit() {
		ui.exit();
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     * @param column kolonne på spille brettet
     * @param row rad på brettet
     * @return
     */
	public static boolean canIMoveTo(int column, int row) {
        return !OutOfBoardFilter.isOutOfBoard(column, row) && ((ApplicationFrame) ui).canIMoveTo(column, row);
    }

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     */
	public static void resetSquares() {
		((ApplicationFrame)ui).resetSquares();
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     * @param column Kolonne på spille brettet
     * @param row Rad på Spillebrettet
     */
	public static void moveTo(int column, int row) {
		if(!OutOfBoardFilter.isOutOfBoard(column, row))
			((ApplicationFrame)ui).moveTo(column, row);
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     * @param column Kolonne på spille brettet
     * @param row Rad på Spillebrettet
     */
	public static void setLastPressed(int column, int row) {
		((ApplicationFrame)ui).setLastPressed(column, row);
	}

    /**
     * CoR meldingsstier <p>
     * Sender melding videre til Application frame<p>
     */
	public static void changePlayerInTurn() {
		((ApplicationFrame)ui).changePlayerInTurn();
	}

    /**
     * CoR meldingsstier <p>
     * Sender melding videre til Application frame<p>
     * @return
     */
	public static String getPlayerInTurn() {
		return ((ApplicationFrame)ui).getPlayerInTurn();
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     * @param toColumn Kolonne på spille brettet
     * @param toRow Rad på spille brettet
     * @return
     */
	public static boolean canICapture(int toColumn, int toRow) {
        return !OutOfBoardFilter.isOutOfBoard(toColumn, toRow) && ((ApplicationFrame) ui).canICapture(toColumn, toRow);
    }

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     */
	public static void checkMate() {
		((ApplicationFrame)ui).checkMate();
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     * @return
     */
	public static String whoWon() {
		return ((ApplicationFrame)ui).whoWon();
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     */
	public static void undoMove() {
		((ApplicationFrame)ui).undoMove();
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     * @param b boolean verdi for å sette setUndoEnable til true eller false
     */
	public static void setUndoEnable(boolean b) {
		((ApplicationFrame)ui).setUndoEnable(b);
        actionundo.setEnabled(b);
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     * @param b boolean verdi for å sette setRedoEnable til true eller false
     */
	public static void setRedoEnable(boolean b) {
		((ApplicationFrame)ui).setRedoEnable(b);
        actionredo.setEnabled(b);
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     */
	public static void redoMove() {
		((ApplicationFrame)ui).redoMove();
	}

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     * @param fen fen notasjons strengen
     */
    public static void addFenInfo(String fen) {
        ((ApplicationFrame)ui).addFenInfo(fen);
    }

    /**
     * CoR meldingsstier<p>
     * Sender melding videre til Application frame<p>
     * @return
     */
    public static String promotionDialog() {
        return ((ApplicationFrame)ui).promotionDialog();

    }
}
