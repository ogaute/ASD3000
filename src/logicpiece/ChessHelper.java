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
	boolean colorOfThisTurnsPlayer = false;
	//FENgenerator fenG = new FENgenerator(); //observer
	//StockFishObservable sfo; //observer
	Square[][] state;
	CheckChecker checkChecker = new CheckChecker();
	//boolean kingIsCheck = false;
	ArrayList<Square> legaMovesWhenKingInCheck = new ArrayList<Square>();

	public ChessHelper() {
		pawn = new PawnLogic();
		knight = new KnightLogic();
        rook = new RookLogic();
        bishop = new BishopLogic();
        queen = new QueenLogic();
        king = new KingLogic();
        
        //sfo = new StockFishObservable(); //observer
        //fenG.addObserver(sfo); //observer
        //sfo.addObserver((Observer)Controller.getSFI()); //observer
        
	}
	
	public ArrayList<Square> canIMove(Piece p, Square[][] state, int x, int y, boolean pieceColor){
		ArrayList<Square> legalMoves = null;
        this.state = state;
		//if()
		
		if(p instanceof Pawn){
			legalMoves = pawn.canIMove(state, x, y, pieceColor, legaMovesWhenKingInCheck);
		}
		if(p instanceof Knight){
            legalMoves = knight.canIMove(state, x, y, pieceColor, legaMovesWhenKingInCheck);
		}
        if(p instanceof Rook){
            legalMoves = rook.canIMove(state,x,y,pieceColor, legaMovesWhenKingInCheck);
        }
        if(p instanceof Bishop){
            legalMoves = bishop.canIMove(state,x,y,pieceColor, legaMovesWhenKingInCheck);
        }
        if(p instanceof Queen){
            legalMoves = queen.canIMove(state,x,y,pieceColor, legaMovesWhenKingInCheck);
        }
        if(p instanceof King){
        	if(pieceColor == colorOfThisTurnsPlayer){
                legalMoves = ((KingLogic)king).canIMove(state,x,y,pieceColor, legaMovesWhenKingInCheck, true);
        	}
        	else{
        		legalMoves = ((KingLogic)king).canIMove(state,x,y,pieceColor, legaMovesWhenKingInCheck, false);
        	}
        }
		
		return legalMoves;
	}

	public boolean turn() {
		return colorOfThisTurnsPlayer;
	}

	public void nextTurn() {
		colorOfThisTurnsPlayer = !colorOfThisTurnsPlayer;
		if(colorOfThisTurnsPlayer)
			System.out.println("Svart sin tur");

		else
			System.out.println("Hvit sin tur");

		//fenG.generateFEN(state);
		legaMovesWhenKingInCheck = checkChecker.isKingInCheck(state);
		
		if(colorOfThisTurnsPlayer)
			System.out.println("Is svart king in check? " + !legaMovesWhenKingInCheck.isEmpty());

		else
			System.out.println("Is hvit king in check? " + !legaMovesWhenKingInCheck.isEmpty());
		

	}

	public ArrayList<PieceInControll> isInControll(Square[][] tryState, Square destination) {
		return checkChecker.isInControll(tryState, destination);
	}
}
