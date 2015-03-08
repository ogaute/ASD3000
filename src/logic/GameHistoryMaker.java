package logic;

import controller.Controller;
import saveLogic.BoardStateList;
import saveLogic.BoardStateHandler;
import gui.ApplicationConstants;
import gui.ChessBoard;
import gui.Square;
import gui.pieceGui.Piece;

/**
 * Klasse som har ansvar for å håndtere spillets historikk.
 */
public class GameHistoryMaker {
	
	
	private ChessBoard board;
	private Square[][] squareList;
	BoardStateHandler boardStateHandler = new BoardStateHandler();
	BoardStateList boardStateList = new BoardStateList();
	int listIndex = 0;

    /**
     * Konstruktør - setter verdi i klassefelt
     * @param board mottar peker til objekt av klassen ChessBoard
     * @param squares mottar peker til liste med squares
     */
	public GameHistoryMaker(ChessBoard board, Square[][] squares) {
		this.board = board;
		this.squareList = squares;
	}

    /**
     * Metode som henter ut piece fra hver enkelt square i squareliste som har dette og legger dette i en liste med pieces
     * @return liste med pieces
     */
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

    /**
     * Metode som lager tilstand til boardStateHandler
     */
	public void saveState(){
		boardStateHandler.setBoardState(boardToPiecesList());
		boardStateList.add(boardStateHandler.saveBoardState());
		if((boardStateList.length()- 1) > listIndex)
			listIndex++;
		setEnableOnUndo();
	}

    /**
     * Metode som enabler undo/redo knapp hvis det finnes historikk
     */
	private void setEnableOnUndo() {
		if(listIndex == (boardStateList.length() - 1)){
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

    /**
     * Metode som ufører tilbakerulling av trekk
     */
	public void undo(){
		//listIndex--;
		if(listIndex >= 0)
			listIndex--;
		if (indexFilter(listIndex)) {
			boardStateHandler.setBoardState(boardStateList.get(listIndex).getBoardState());
			board.removePieces();
			board.changeGameState(boardStateHandler.getBoardState());
			Controller.changePlayerInTurn();
			setEnableOnUndo();
		}
	}

    /**
     * Metode som gjøre tilbakerullet trekk om igjen
     */
	public void redo(){
		if((boardStateList.length()- 1) > listIndex)
			listIndex++;
		if (indexFilter(listIndex)) {
			boardStateHandler.setBoardState(boardStateList.get(listIndex).getBoardState());
			board.removePieces();
			board.changeGameState(boardStateHandler.getBoardState());
			Controller.changePlayerInTurn();
			setEnableOnUndo();
		}
	}

    /**
     * Metode som filtrere bort ulovlige indexer
     * @param index index som skal valideres
     * @return om index er lovlig eller ikke
     */
	private boolean indexFilter(int index){
		boolean indexLegal = false;
		if(index >= 0 || index <= (boardStateList.length() - 1))
			indexLegal = true;
		return indexLegal;
	}
	
	
}
