package logic;

import controller.Controller;
import saveLogic.CareTaker;
import saveLogic.Originator;
import gui.ApplicationConstants;
import gui.ChessBoard;
import gui.Square;
import gui.pieceGui.Piece;

public class BoardHistory {
	
	
	private ChessBoard board;
	private Square[][] squareList;
	Originator originator = new Originator();
	CareTaker careTaker = new CareTaker();
	int listIndex = 0;

	public BoardHistory(ChessBoard board, Square[][] squares) {
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
		originator.setState( boardToPiecesList() );
		careTaker.add(originator.saveStateToMemento());
		if((careTaker.length()- 1) > listIndex)
			listIndex++;
		System.out.println("BoardListory" + 
		" index " + listIndex +
		" størrelsen er " + careTaker.length() +
		" Listen: " + originator.getState());	
		setEnableOnUndo();
	}

	private void setEnableOnUndo() {
		if(listIndex == (careTaker.length() - 1)){
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
			originator.setState(careTaker.get(listIndex).getState());
			board.removePieces();
			board.changeGameState(originator.getState());
			Controller.changePlayerInTurn();
			System.out.println("BoardListory" + 
					" index " + listIndex +
					" størrelsen er " + careTaker.length() +
					" Listen: " + originator.getState());
			setEnableOnUndo();
		}
	}
	
	public void redo(){
		if((careTaker.length()- 1) > listIndex)
			listIndex++;
		if (indexFilter(listIndex)) {
			originator.setState(careTaker.get(listIndex).getState());
			board.removePieces();
			board.changeGameState(originator.getState());
			Controller.changePlayerInTurn();
			System.out.println("BoardListory" + 
					" index " + listIndex +
					" størrelsen er " + careTaker.length() +
					" Listen: " + originator.getState());
			setEnableOnUndo();
		}
	}
	
	private boolean indexFilter(int index){
		boolean indexLegal = false;
		if(index >= 0 || index <= (careTaker.length() - 1))
			indexLegal = true;
		return indexLegal;
	}
	
	
}
