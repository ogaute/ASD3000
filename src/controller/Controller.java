package controller;

import easylib.controller.ISupercontroller;
import easylib.controller.Supercontroller;
import gui.ApplicationFrame;

public class Controller extends Supercontroller implements IActionlist {


	public static void init(ISupercontroller frame) {
		superinit(frame);

	}

	public static boolean canIMoveTo(int column, int row) {
		return ((ApplicationFrame)ui).canIMoveTo(column, row);
	}

	public static void resetSquares() {
		((ApplicationFrame)ui).resetSquares();
	}

	public static void moveTo(int column, int row) {
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
	
	
}
