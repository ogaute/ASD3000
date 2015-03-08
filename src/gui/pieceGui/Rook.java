package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

/**
 * Klasse Rook har ansvar for sette riktig bilde, svart eller hvit Rook, i Piece.
 * Utvider klassen Piece som er en AbstractButton.
 */
public class Rook extends Piece {
	
	
	private PieceMessage rookLogic;

    /**
     * Rook<p>
     * Setter bildefil til en svart eller hvit brikke og forepør en instans av rookLogic fra PiecLogicFactory
     * @param isBlack hvorvidt en brikke er svart eller ikke
     */
	public Rook(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_Rook.png");
			this.rookLogic= new PieceLogicFactory().getPieceLogic("ROOK", ApplicationConstants.BLACK);
			
		}
		else{
			setImage("img/White_Rook.png");
			this.rookLogic = new PieceLogicFactory().getPieceLogic("ROOK", ApplicationConstants.WHITE);
		}
	}

    /**
     * Metode som returnerer FENSymbol fra rookLogic som brukes for å identifisere brikken i en FEN string
     * @return String med FENsymbol
     */
	@Override
	public String getFENSymbol() {
		return rookLogic.getFENSymbol();
	}

    /**
     * Metode som sender melding til rookLogic om hvilken kolonne og rad som er trykket på av bruker
     * @param column kolonne som er trykket på
     * @param row rad som et trykket på
     */
	@Override
	public void pressed(int column, int row) {
		rookLogic.pressed(column, row);
	}

	
}
