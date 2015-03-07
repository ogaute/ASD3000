package saveLogic;

import gui.pieceGui.Piece;

/*
Den holder på tilstanden til et objekt  som kan gjennopprettes.
(Memento)
 */
public class BoardState {
	private Piece[][] boardState;

    /**
     *
     * @param boardState
     */
	public BoardState(Piece[][] boardState) {
		this.boardState = boardState;
	}

    /**
     *
     * @return
     */
	public Piece[][] getBoardState() {
		return boardState;
	}
}
