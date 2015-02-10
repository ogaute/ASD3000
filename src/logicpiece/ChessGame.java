package logicpiece;

import gui.Square;
import guipiece.*;

import java.util.ArrayList;

public class ChessGame {
	
	PieceLogic pawn;
	PieceLogic knight;
    PieceLogic rook;
    PieceLogic bishop;
    PieceLogic queen;
    PieceLogic king;
	boolean currentPlayer = false;

	public ChessGame() {
		pawn = new PawnLogic();
		knight = new KnightLogic();
        rook = new RookLogic();
        bishop = new BishopLogic();
        queen = new QueenLogic();
        king = new KingLogic();
	}
	
	public ArrayList<Square> canIMove(Piece p, Square[][] state, int x, int y, boolean c){
		ArrayList<Square> legalMoves = null;
		
		if(p instanceof Pawn){
			legalMoves = pawn.canIMove(state, x, y, c);
		}
		if(p instanceof Knight){
            legalMoves = knight.canIMove(state, x, y, c);
		}
        if(p instanceof Rook){
            legalMoves = rook.canIMove(state,x,y,c);
        }
        if(p instanceof Bishop){
            legalMoves = bishop.canIMove(state,x,y,c);
        }
        if(p instanceof Queen){
            legalMoves = queen.canIMove(state,x,y,c);
        }
        if(p instanceof King){
            legalMoves = king.canIMove(state,x,y,c);
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
