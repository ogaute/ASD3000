package gui;

import gui.pieceGui.*;


public interface ApplicationConstants {


	String WHITE  = "hvit";
	String BLACK = "svart";

    String SYMBOL_BLACK_ROOK = "r";
    String SYMBOL_WHITE_ROOK = "R";
    String SYMBOL_BLACK_KING = "k";
    String SYMBOL_WHITE_KING = "K";
    String SYMBOL_BLACK_BISHOP = "b";
    String SYMBOL_WHITE_BISHOP = "B";
    String SYMBOL_BLACK_KNIGHT = "n";
    String SYMBOL_WHITE_KNIGHT = "N";
    String SYMBOL_BLACK_QUEEN = "q";
    String SYMBOL_WHITE_QUEEN = "Q";
    String SYMBOL_BLACK_PAWN = "p";
    String SYMBOL_WHITE_PAWN = "P";
	
	/*0 til 7, antall 8*/
	int NUMCOLUMNS = 7;
	int NUMROWS = 7;
	
	Piece[][] MARSHALLING = {
			{new Rook(true), new Knight(true), new Bishop(true), new Queen(true), King.getBlackKingInstance(true), new Bishop(true), new Knight(true), new Rook(true)},
			{new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true)},
			
			{null,null, null, null, null, null, null, null}, 
			{null,null, null, null, null, null, null, null}, 
			{null,null, null, null, null, null, null, null}, 
			{null,null, null, null, null, null, null, null}, 
			
			{new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false)},
			{new Rook(false), new Knight(false), new Bishop(false), new Queen(false), King.getWhiteKingInstance(false), new Bishop(false), new Knight(false), new Rook(false)}
	};
	
	String[][] CHESSCOORDINATES = {
			{"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
			{"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
			
			{"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"}, 
			{"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"}, 
			{"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"}, 
			{"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"}, 
			
			{"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"}, 
			{"a1", "b1", "c1", "d1", "e1", "f1", ",0g1", "h1"}
	};
	

}
