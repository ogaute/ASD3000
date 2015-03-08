package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

/**
 * Klasse King har ansvar for sette riktig bilde, svart eller hvit King, i Piece.
 * Utvider klassen Piece som er en AbstractButton.
 */
public class King extends Piece{
	
	
	private PieceMessage kingLogic;
	private static int num_white_king = 0;
	private static int num_black_king = 0;
	private static King whiteKing = null;
	private static King blackKing = null;

    /**
     * King<p>
     * Henter bildefil til en svart eller hvit brikke av King og forepør en instans av KingLogic fra PiecLogicFactory
     * @param isBlack hvorvidt en brikke er svart eller ikke
     */
	private King(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_King.png");
			num_black_king++;
			this.kingLogic = new PieceLogicFactory().getPieceLogic("KING", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_King.png");
			num_white_king++;
			this.kingLogic = new PieceLogicFactory().getPieceLogic("KING", ApplicationConstants.WHITE);
		}
	}

    /**
     * Metode som returnerer en instans av white King.
     * Nytt objekt instansierer kun hvis dette ikke er gjort tidligere i spillet
     * @return instans av black King
     */
	public static King getWhiteKingInstance(){
		if (num_white_king == 0){
			whiteKing = new King(false);
		}
		return whiteKing;
	}

    /**
     * Metode som returnerer en instans av black King.
     * Nytt objekt instansierer kun hvis dette ikke er gjort tidligere i spillet
     * @return instans av black King
     */
	public static King getBlackKingInstance(){
		if (num_black_king == 0){
			blackKing = new King(true);
		}
		return blackKing;
	}

    /**
     * Metode som returnerer FENSymbol fra kingLogic som brukes for å identifisere brikken i en FEN string
     * @return String med FENsymbol
     */
	@Override
	public String getFENSymbol() {
		return kingLogic.getFENSymbol();
	}

    /**
     * Metode som sender melding til kingLogic om  hvilken kolonne og rad som er trykket på av bruker
     * @param column kolonne som er trykket på
     * @param row rad som et trykket på
     */
	@Override
	public void pressed(int column, int row) {
		kingLogic.pressed(column, row);
	}
	
	
}
