package controller;

import easylib.controller.ISupercontroller;
import easylib.controller.SuperAction;
import easylib.controller.Supercontroller;
import gui.ApplicationFrame;
import logic.OutOfBoardFilter;

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
     *
     */
	public static void exit() {
		ui.exit();
	}

    /**
     * CoR meldingsstier
     * @param column
     * @param row
     * @return
     */
	public static boolean canIMoveTo(int column, int row) {
        return !OutOfBoardFilter.isOutOfBoard(column, row) && ((ApplicationFrame) ui).canIMoveTo(column, row);
    }

    /**
     * CoR meldingsstier
     */
	public static void resetSquares() {
		((ApplicationFrame)ui).resetSquares();
	}

    /**
     * CoR meldingsstier
     * @param column
     * @param row
     */
	public static void moveTo(int column, int row) {
		if(!OutOfBoardFilter.isOutOfBoard(column, row))
			((ApplicationFrame)ui).moveTo(column, row);
	}

    /**
     *
     * @param column
     * @param row
     */
	public static void setLastPressed(int column, int row) {
		((ApplicationFrame)ui).setLastPressed(column, row);
	}

    /**
     * CoR meldingsstier
     */
	public static void changePlayerInTurn() {
		((ApplicationFrame)ui).changePlayerInTurn();
	}

    /**
     * CoR meldingsstier
     * @return
     */
	public static String getPlayerInTurn() {
		return ((ApplicationFrame)ui).getPlayerInTurn();
	}

    /**
     * CoR meldingsstier
     * @param toColumn
     * @param toRow
     * @return
     */
	public static boolean canICapture(int toColumn, int toRow) {
        return !OutOfBoardFilter.isOutOfBoard(toColumn, toRow) && ((ApplicationFrame) ui).canICapture(toColumn, toRow);
    }

    /**
     * CoR meldingsstier
     */
	public static void checkMate() {
		((ApplicationFrame)ui).checkMate();
	}

    /**
     * CoR meldingsstier
     * @return
     */
	public static String whoWon() {
		return ((ApplicationFrame)ui).whoWon();
	}

    /**
     * CoR meldingsstier
     */
	public static void undoMove() {
		((ApplicationFrame)ui).undoMove();
	}

    /**
     * CoR meldingsstier
     * @param b
     */
	public static void setUndoEnable(boolean b) {
		((ApplicationFrame)ui).setUndoEnable(b);
        actionundo.setEnabled(b);
	}

    /**
     * CoR meldingsstier
     * @param b
     */
	public static void setRedoEnable(boolean b) {
		((ApplicationFrame)ui).setRedoEnable(b);
        actionredo.setEnabled(b);
	}

    /**
     * CoR meldingsstier
     */
	public static void redoMove() {
		((ApplicationFrame)ui).redoMove();
	}

    /**
     * CoR meldingsstier
     * @param fen
     */
    public static void addFenInfo(String fen) {
        ((ApplicationFrame)ui).addFenInfo(fen);
    }

    /**
     * CoR meldingsstier
     * @return
     */
    public static String promotionDialog() {
        return ((ApplicationFrame)ui).promotionDialog();

    }
}
