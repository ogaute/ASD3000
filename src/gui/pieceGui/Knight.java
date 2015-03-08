package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

/**
 * Klasse Knight har ansvar for sette riktig bilde, svart eller hvit Knight, i Piece.
 * Utvider klassen Piece som er en AbstractButton.
 */
public class Knight extends Piece {
	
	
	private PieceMessage knightLogic;

    /**
     * Knight<p>
     * Setter bildefil til en svart eller hvit brikke og forepør en instans av knightLogic fra PiecLogicFactory
     * @param isBlack hvorvidt en brikke er svart eller ikke
     */
	public Knight(boolean isBlack) {
		super();
		if(isBlack){
			setImage("img/Black_Knight.png");
			this.knightLogic = new PieceLogicFactory().getPieceLogic("KNIGHT", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_Knight.png");
			this.knightLogic = new PieceLogicFactory().getPieceLogic("KNIGHT", ApplicationConstants.WHITE);
		}
	}

    /**
     * Metode som returnerer FENSymbol fra knightLogic som brukes for å identifisere brikken i en FEN string
     * @return String med FENsymbol
     */
	@Override
	public String getFENSymbol() {
		return knightLogic.getFENSymbol();
	}

    /**
     * Metode som sender melding til knightLogic om hvilken kolonne og rad som er trykket på av bruker
     * @param column kolonne som er trykket på
     * @param row rad som et trykket på
     */
	@Override
	public void pressed(int column, int row) {
		knightLogic.pressed(column, row);
	}

	
}
