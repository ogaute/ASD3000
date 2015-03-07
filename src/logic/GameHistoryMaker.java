package logic;

import controller.Controller;
import saveLogic.BoardStateHistory;
import saveLogic.BoardStateCreator;
import gui.ApplicationConstants;
import gui.ChessBoard;
import gui.Square;
import gui.pieceGui.Piece;

public class GameHistoryMaker {
	
	
	private ChessBoard board;
	private Square[][] squareList;
	BoardStateCreator boardStateCreator = new BoardStateCreator();
	BoardStateHistory boardStateHistory = new BoardStateHistory();
	int listIndex = 0;

	public GameHistoryMaker(ChessBoard board, Square[][] squares) {
		this.board = board;
		this.squareList = squares;
	}
	
	private Piece[][] boardToPiecesList(){
		Piece[][] piecesList = new Piece[8][8];
		for (int row = 0; row <= ApplicationConstants.NUMROWS; row++) {
			for (int column = 0; column <= ApplicationConstants.NUMCOLUMNS; column++) {
				if(squareList[column][row].hasChild())
					piecesList[column][row] = squareList[column][row].getPiece();
				else
					piecesList[column][row] = null;
			}
		}
		return piecesList;
	}
	
	public void saveState(){
		boardStateCreator.setBoardState(boardToPiecesList());
		boardStateHistory.add(boardStateCreator.saveStateToMemento());
		if((boardStateHistory.length()- 1) > listIndex)
			listIndex++;
		System.out.println("BoardListory" + 
		" index " + listIndex +
		" størrelsen er " + boardStateHistory.length() +
		" Listen: " + boardStateCreator.getBoardState());
		setEnableOnUndo();
	}

	private void setEnableOnUndo() {
		if(listIndex == (boardStateHistory.length() - 1)){
			Controller.setRedoEnable(false);
		}
		else{
			Controller.setRedoEnable(true);
		}
	
		if(listIndex == 0){
			Controller.setUndoEnable(false);
		}
		else{
			Controller.setUndoEnable(true);
		}
	}
	
	public void undo(){
		//listIndex--;
		if(listIndex >= 0)
			listIndex--;
		if (indexFilter(listIndex)) {
			boardStateCreator.setBoardState(boardStateHistory.get(listIndex).getBoardState());
			board.removePieces();
			board.changeGameState(boardStateCreator.getBoardState());
			Controller.changePlayerInTurn();
			System.out.println("BoardListory" + 
					" index " + listIndex +
					" størrelsen er " + boardStateHistory.length() +
					" Listen: " + boardStateCreator.getBoardState());
			setEnableOnUndo();
		}
	}
	
	public void redo(){
		if((boardStateHistory.length()- 1) > listIndex)
			listIndex++;
		if (indexFilter(listIndex)) {
			boardStateCreator.setBoardState(boardStateHistory.get(listIndex).getBoardState());
			board.removePieces();
			board.changeGameState(boardStateCreator.getBoardState());
			Controller.changePlayerInTurn();
			System.out.println("BoardListory" + 
					" index " + listIndex +
					" størrelsen er " + boardStateHistory.length() +
					" Listen: " + boardStateCreator.getBoardState());
			setEnableOnUndo();
		}
	}
	
	private boolean indexFilter(int index){
		boolean indexLegal = false;
		if(index >= 0 || index <= (boardStateHistory.length() - 1))
			indexLegal = true;
		return indexLegal;
	}
	
	
}