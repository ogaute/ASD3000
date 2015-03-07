package saveLogic;

import gui.pieceGui.Piece;

/*
Den holder på tilstanden til et objekt  som kan gjennopprettes.
 */
public class BoardState {
	private Piece[][] boardState;

	public BoardState(Piece[][] boardState) {
		this.boardState = boardState;
	}

	public Piece[][] getBoardState() {
		return boardState;
	}
}
