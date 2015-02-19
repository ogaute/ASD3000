package logicpiece;

import gui.Square;
import guipiece.Bishop;
import guipiece.King;
import guipiece.Knight;
import guipiece.Pawn;
import guipiece.Piece;
import guipiece.Queen;
import guipiece.Rook;

import java.util.ArrayList;
import java.util.Observer;

import stockfish.FENgenerator;
import stockfish.StockFishObservable;
import controller.Controller;

public class ChessHelper {
	
	PieceLogic pawn;
	PieceLogic knight;
    PieceLogic rook;
    PieceLogic bishop;
    PieceLogic queen;
    PieceLogic king;
	boolean currentPlayer = false;
	FENgenerator fenG = new FENgenerator();
	StockFishObservable sfo;
	Square[][] state;
	CheckChecker checkChecker = new CheckChecker();
	boolean kingIsCheck = false;

	public ChessHelper() {
		pawn = new PawnLogic();
		knight = new KnightLogic();
        rook = new RookLogic();
        bishop = new BishopLogic();
        queen = new QueenLogic();
        king = new KingLogic();
        
        sfo = new StockFishObservable();
        fenG.addObserver(sfo);
        sfo.addObserver((Observer)Controller.getSFI());
        
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

        this.state = state;
		
		return legalMoves;
	}

	public boolean turn() {
		return currentPlayer;
	}

	public void nextTurn() {
		currentPlayer = !currentPlayer;
		//fenG.generateFEN(state);
		//System.out.println("aloha");
		kingIsCheck = checkChecker.isKingInCheck(state);
		System.out.println("Is king in check? " + kingIsCheck);


	}
}
