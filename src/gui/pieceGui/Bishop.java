package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

/**
 * Klasse Bishop har ansvar for sette riktig bilde, svart eller hvit Bishop, i Piece.
 * Utvider klassen Piece som er en AbstractButton.
 */
public class Bishop extends Piece {
	
	
	private PieceMessage bishopLogic;

    /**
     * Bishop<p>
     * Henter bildefil til en svart eller hvit brikke og forepør en instans av bishopLogic fra PiecLogicFactory
     * @param isBlack hvorvidt en brikke er svart eller ikke
     */
	public Bishop(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_Bishop.png");
			this.bishopLogic = new PieceLogicFactory().getPieceLogic("BISHOP", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_Bishop.png");
			this.bishopLogic = new PieceLogicFactory().getPieceLogic("BISHOP", ApplicationConstants.WHITE);
		}
	}

    /**
     * Metode som returnerer FENSymbol fra bishopLogic som brukes for å identifisere brikken i en FEN string
     * @return String med FENsymbol
     */
	@Override
	public String getFENSymbol() {
		return bishopLogic.getFENSymbol();
	}

    /**
     * Metode som sender melding til bishopLogic om  hvilken kolonne og rad som er trykket på av bruker
     * @param column kolonne som er trykket på
     * @param row rad som et trykket på
     */
	@Override
	public void pressed(int column, int row) {
		bishopLogic.pressed(column, row);
	}
	
	
}
