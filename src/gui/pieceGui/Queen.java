package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

/**
 * Klasse Queen har ansvar for sette riktig bilde, svart eller hvit Queen, i Piece.
 * Utvider klassen Piece som er en AbstractButton.
 */
public class Queen extends Piece {
	
	
	private PieceMessage queenLogic;

    /**
     * Queen<p>
     * Henter bildefil til en svart eller hvit brikke og forepør en instans av queenLogic fra PiecLogicFactory
     * @param isBlack hvorvidt en brikke er svart eller ikke
     */
	public Queen(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_Queen.png");
			this.queenLogic = new PieceLogicFactory().getPieceLogic("QUEEN", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_Queen.png");
			this.queenLogic = new PieceLogicFactory().getPieceLogic("QUEEN", ApplicationConstants.WHITE);
		}
	}

    /**
     * Metode som returnerer FENSymbol fra queenLogic som brukes for å identifisere brikken i en FEN string
     * @return String med FENsymbol
     */
	@Override
	public String getFENSymbol() {
		return queenLogic.getFENSymbol();
	}

    /**
     * Metode som sender melding til queenLogic om hvilken kolonne og rad som er trykket på av bruker
     * @param column kolonne som er trykket på
     * @param row rad som et trykket på
     */
	@Override
	public void pressed(int column, int row) {
		queenLogic.pressed(column, row);
	}
	

}
