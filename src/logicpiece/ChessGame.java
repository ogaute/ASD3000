package logicpiece;

import gui.Square;
import guipiece.*;

import java.util.ArrayList;

public class ChessGame {
	
	PawnLogic pawn;
	boolean currentPlayer = false;

	public ChessGame() {
		pawn = new PawnLogic();
	}
	
	public ArrayList<Square> canIMove(Piece p, Square[][] state, int x, int y, boolean c){
		ArrayList<Square> legalMoves = null;
		
		if(p instanceof Pawn){
			legalMoves = pawn.canIMove(state, x, y, c);
		}
		
		return legalMoves;
	}

	public boolean turn() {
		return currentPlayer;
	}

	public void nextTurn() {
		currentPlayer = !currentPlayer;
	}
}
