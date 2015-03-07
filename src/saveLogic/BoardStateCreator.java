package saveLogic;

import gui.pieceGui.Piece;

/*
 Lager og lagrer tilstanden i et BoardState objekt.
 */
public class BoardStateCreator {
	private Piece[][] boardState;

	public void setBoardState(Piece[][] boardState) {
		this.boardState = boardState;
	}

	public Piece[][] getBoardState() {
		return boardState;
	}

	public BoardState saveStateToMemento() {
		return new BoardState(boardState);
	}

	public void getStateFromMemento(BoardState BoardState) {
		boardState = BoardState.getBoardState();
	}
}
