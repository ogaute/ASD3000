package saveLogic;

import gui.pieceGui.Piece;

/**
 * Klassen BoardStateHandler har ansvar for å håndtere nåværende stilling
 * på brettet og å lage en ny stilling på brettet.
 * 
 * Klassen er med på å skape mønsteret Memento, og fungerer som originator.
 */

public class BoardStateHandler {
	
	
	private Piece[][] boardState;

    /**
     * Setter klassefeltvariabel til å være lik 
     * det som mottas som innparameter.
     * 
     * @param boardState Et todemensjonalt array av objekter av typen Piece
     */
	public void setBoardState(Piece[][] boardState) {
		this.boardState = boardState;
	}

    /**
     * Returnerer brettstillingen
     * 
     * @return Returnerer innholdet i klassefeltvariabelen boardState
     */
	public Piece[][] getBoardState() {
		return boardState;
	}

    /**
     * Lagrer en ny brettstilling
     * 
     * @return Returnerer et nytt objekt av typen BoardState som mottar brettstillingen som innparameter
     */
	public BoardState saveBoardState() {
		return new BoardState(boardState);
	}


}
