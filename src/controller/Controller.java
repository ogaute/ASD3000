package controller;

import java.util.ArrayList;

import easylib.controller.ISupercontroller;
import easylib.controller.Supercontroller;
import gui.Square;
import guipiece.Piece;

public class Controller extends Supercontroller implements IActionlist {


	public static void init(ISupercontroller frame) {
		superinit(frame);

	}
	
	public static ArrayList<Square> canIMove(Piece p, Square[][] state, int x, int y, boolean c){
		return ui.canIMove(p, state, x, y, c);
	}

	public static boolean turn(){
		return ui.turn();
	}

	public static void nextTurn() {
		ui.nextTurn();
	}

}
