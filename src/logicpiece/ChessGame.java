package logicpiece;

import gui.Square;
import guipiece.*;

import java.util.ArrayList;

public class ChessGame {
	
	PieceLogic pawn;
	PieceLogic knight;
	boolean currentPlayer = false;

	public ChessGame() {
		pawn = new PawnLogic();
		knight = new KnightLogic();
	}
	
	public ArrayList<Square> canIMove(Piece p, Square[][] state, int x, int y, boolean c){
		ArrayList<Square> legalMoves = null;
		
		if(p instanceof Pawn){
			legalMoves = pawn.canIMove(state, x, y, c);
		}
		
		if(p instanceof Knight){
			legalMoves = knight.canIMove(state, x, y, c);
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
