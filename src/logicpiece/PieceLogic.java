package logicpiece;

import gui.Square;

import java.util.ArrayList;
import java.util.Iterator;

public class PieceLogic {
	
	ArrayList<Square> possibleMove = new ArrayList<Square>();
	
	public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c){
		possibleMove.clear();
		return possibleMove;	
	}

}
