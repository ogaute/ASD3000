package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

/**
 * Klasse Pawn har ansvar for sette riktig bilde, svart eller hvit Pawn, i Piece.
 * Utvider klassen Piece som er en AbstractButton.
 */
public class Pawn extends Piece {
	
	
	private PieceMessage pawnLogic;

    /**
     * Pawn<p>
     * Setter bildefil til en svart eller hvit brikke og forepør en instans av pawnLogic fra PiecLogicFactory
     * @param isBlack hvorvidt en brikke er svart eller ikke
     */
	public Pawn(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_Pawn.png");
			this.pawnLogic = new PieceLogicFactory().getPieceLogic("PAWN", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_Pawn.png");
			this.pawnLogic = new PieceLogicFactory().getPieceLogic("PAWN", ApplicationConstants.WHITE);
		}
	}

    /**
     * Metode som returnerer FENSymbol fra pawnLogic som brukes for å identifisere brikken i en FEN string
     * @return String med FENsymbol
     */
	@Override
	public String getFENSymbol() {
		return pawnLogic.getFENSymbol();
	}

    /**
     * Metode som sender melding til pawnLogic om hvilken kolonne og rad som er trykket på av bruker
     * @param column kolonne som er trykket på
     * @param row rad som et trykket på
     */
	@Override
	public void pressed(int column, int row) {
		pawnLogic.pressed(column, row);
	}
	

}
