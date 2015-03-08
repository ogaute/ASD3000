package gui;

import gui.pieceGui.*;

/**
 *  ApplicationConstants er et interface og har ansvar for å sette konstanter som brukes i applikasjonen
 */
public interface ApplicationConstants {

    /**
     *  Stenger som blir brukt til å sette hvit eller svart
     */
	String WHITE  = "hvit";
	String BLACK = "svart";

    /**
     *Strenger som blir brukt til å sette riktig symboler på brikkene. Brukes når det genereres FEN-streng.
     */
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
	
	/**
     * index er 0 til 7, gir et antall på 8
     * Brukes til å sette antall rader og kolonner
     * */
	int NUMCOLUMNS = 7;
	int NUMROWS = 7;

	/**
	 * Brukes for å begrense rekkevidde i flytting. 
	 * Default er at det er maksimalt 7 flyttinger i retning innenfor brettet for offiserer.
	 * Kongen har kun ett trekk som maksimalt antall flyttinger i retning innenfor brettet.
	 */
	int DEFAULTSTEPS = 7;
	int KINGSTEPS = 1;
	
    /**
     * Brukes til å sette ut brikkene på spillebrettet ved oppstart av nytt spill.
     */
	Piece[][] MARSHALLING = {
			{new Rook(true), new Knight(true), new Bishop(true), new Queen(true), King.getBlackKingInstance(), new Bishop(true), new Knight(true), new Rook(true)},
			{new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true)},
			
			{null,null, null, null, null, null, null, null}, 
			{null,null, null, null, null, null, null, null}, 
			{null,null, null, null, null, null, null, null}, 
			{null,null, null, null, null, null, null, null}, 
			
			{new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false)},
			{new Rook(false), new Knight(false), new Bishop(false), new Queen(false), King.getWhiteKingInstance(), new Bishop(false), new Knight(false), new Rook(false)}
	};
	
	/**
	 * Brukes til å legge på riktige kolonnekoordinater rundt brettet
	 */
	String[] LETTERS = { "A", "B", "C", "D", "E", "F", "G", "H" };
	
    /**
     * Brukes til å oversette fra todimensjonalt array bestående av kolonner/rader med indekser til sjakkkoordinater på spillebrettet.
     */
	String[][] CHESSCOORDINATES = {
			{"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
			{"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
			
			{"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"}, 
			{"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"}, 
			{"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"}, 
			{"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"}, 
			
			{"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"}, 
			{"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"}
	};
	

}
