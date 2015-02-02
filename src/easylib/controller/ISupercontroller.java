package easylib.controller;

import gui.Square;
import guipiece.Piece;

import java.util.ArrayList;


public interface ISupercontroller {	
	void about();
	void exit();
	void setStatustext(String s);
	
	ArrayList<Square> canIMove(Piece p, Square[][] state, int x, int y, boolean c);
}
