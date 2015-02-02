package logicpiece;

import gui.Square;
import guipiece.*;

import java.util.ArrayList;

public class ChessGame {
	
	PawnLogic pawn;

	public ChessGame() {
		pawn = new PawnLogic();
	}
	
	public ArrayList<Square> canIMove(Piece p, Square[][] state, int x, int y, boolean c){
		ArrayList<Square> legalMoves = null;
		
		if(p.getClass().isInstance(Pawn.class)){
			legalMoves = pawn.canIMove(state, x, y, c);
		}
		
		return legalMoves;
	}
}
