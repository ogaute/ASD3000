package controller;

import logic.OutOfBoardFilter;
import easylib.controller.ISupercontroller;
import easylib.controller.Supercontroller;

import gui.ApplicationFrame;

public class Controller extends Supercontroller implements IActionlist {


	public static void init(ISupercontroller frame) {
		superinit(frame);
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
	
	
}
