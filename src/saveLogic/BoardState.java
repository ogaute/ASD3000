package saveLogic;

import gui.pieceGui.Piece;

/**
 * Klassen BoardState har som ansvar å holde på tilstanden til en 
 * spillebrettstilling som kan gjenopprettes ved en senere anledning.
 * 
 * Klassen er med på å skape mønsteret Memento
 */

public class BoardState {
	
	
	private Piece[][] boardState;

    /**
     * Konstruktør. Setter klassefeltvariabel til å være lik 
     * det som mottas som innparameter.
     *
     * @param boardState Et todemensjonalt array av objekter av typen Piece
     */
	public BoardState(Piece[][] boardState) {
		this.boardState = boardState;
	}

    /**
     * Returnerer brettstillingen.
     * 
     * @return Returnerer innholdet i klassefeltvariabelen boardState
     */
	public Piece[][] getBoardState() {
		return boardState;
	}
	
	
}
