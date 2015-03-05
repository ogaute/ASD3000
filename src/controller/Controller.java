package controller;

import easylib.controller.ISupercontroller;
import easylib.controller.SuperAction;
import easylib.controller.Supercontroller;
import gui.ApplicationFrame;
import logic.OutOfBoardFilter;

public class Controller extends Supercontroller implements IActionlist {

	public static SuperAction actionundo;
	public static SuperAction actionredo;

	public static void init(ISupercontroller frame) {
		superinit(frame);
		actionundo = new AUndo(UNDO);
		actionredo = new ARedo(REDO);
	}
	
	public static void exit() {
		((ApplicationFrame)ui).exit();
	}

	public static boolean canIMoveTo(int column, int row) {
		if(OutOfBoardFilter.isOutOfBoard(column, row))
			return false;
		else
			return ((ApplicationFrame)ui).canIMoveTo(column, row);
	}

	public static void resetSquares() {
		((ApplicationFrame)ui).resetSquares();
	}

	public static void moveTo(int column, int row) {
		if(!OutOfBoardFilter.isOutOfBoard(column, row))
			((ApplicationFrame)ui).moveTo(column, row);
	}

	public static void setLastPressed(int column, int row) {
		((ApplicationFrame)ui).setLastPressed(column, row);
	}

	public static void changePlayerInTurn() {
		((ApplicationFrame)ui).changePlayerInTurn();
	}

	public static String getPlayerInTurn() {
		return ((ApplicationFrame)ui).getPlayerInTurn();
	}

	public static boolean canICapture(int toColumn, int toRow) {
		if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
			return false;
		else
			return ((ApplicationFrame)ui).canICapture(toColumn, toRow);
	}

	public static void checkMate() {
		((ApplicationFrame)ui).checkMate();
	}

	public static String whoWon() {
		return ((ApplicationFrame)ui).whoWon();
	}

	public static void undoMove() {
		((ApplicationFrame)ui).undoMove();
	}

	public static void setUndoEnable(boolean b) {
		((ApplicationFrame)ui).setUndoEnable(b);
	}
	
	public static void setRedoEnable(boolean b) {
		((ApplicationFrame)ui).setRedoEnable(b);
	}

	public static void redoMove() {
		((ApplicationFrame)ui).redoMove();
	}

	
}
