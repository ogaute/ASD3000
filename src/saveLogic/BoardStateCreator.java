package saveLogic;

import gui.pieceGui.Piece;

/*
 Lager og lagrer tilstanden i et BoardState objekt.
 (Originator)
 */
public class BoardStateCreator {
	private Piece[][] boardState;

	public void setBoardState(Piece[][] boardState) {
		this.boardState = boardState;
	}

	public Piece[][] getBoardState() {
		return boardState;
	}

	public BoardState saveBoardState() {
		return new BoardState(boardState);
	}

//	ikke i bruk
// public void getHistoryBoardState(BoardState BoardState) {
//		boardState = BoardState.getBoardState();
//	}
}
