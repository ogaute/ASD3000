package controller;

import java.util.ArrayList;

import easylib.controller.ISupercontroller;
import easylib.controller.Supercontroller;
import gui.ApplicationFrame;
import gui.Square;
import gui.StockFishInfo;
import guipiece.Piece;

public class Controller extends Supercontroller implements IActionlist {


	public static void init(ISupercontroller frame) {
		superinit(frame);

	}
	
	public static ArrayList<Square> canIMove(Piece p, Square[][] state, int x, int y, boolean c){
		return ((ApplicationFrame)ui).canIMove(p, state, x, y, c);
	}

	public static boolean turn(){
		return ((ApplicationFrame)ui).turn();
	}

	public static void nextTurn() {
		((ApplicationFrame)ui).nextTurn();
	}
	
	public static StockFishInfo getSFI(){
		return ((ApplicationFrame)ui).getSFI();
	}

	public static void pressed(int indexX, int indexY) {
		((ApplicationFrame)ui).pressed(indexX, indexY);
	}

	public static void addToHistory() {
		((ApplicationFrame)ui).addToHistory();
	}

	public static ArrayList<Square> getKings() {
		return ((ApplicationFrame)ui).getKings();
	}
	
}
