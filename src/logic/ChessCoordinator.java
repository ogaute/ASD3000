package logic;

import gui.ChessBoard;
import gui.Marshalling;
import gui.Square;
import gui.pieceGui.Piece;

public class ChessCoordinator {
	private Square[][] squareList;
	private Square lastPressedSquare;
	private String playerInTurn = Marshalling.WHITE;
	
	public ChessCoordinator(ChessBoard board) {
		squareList = board.addPieces();
	}

	public boolean canIMoveTo(int column, int row) {
		boolean canMove = false;
		
		if(column <= Marshalling.NUMROWS && 
				row <= Marshalling.NUMCOLUMNS &&
				column >= 0 && row >= 0){
			canMove = true;
			squareList[column][row].setLegalSquare(true);
		}
		System.out.println("asked for " + column + "(c) and " + row +"(r), ansvar:" + canMove);
		
		return canMove;
	}
	
	public void resetSquares(){
		for (int row = 0; row <= Marshalling.NUMCOLUMNS; row++) {
			for (int column = 0; column <= Marshalling.NUMROWS; column++) {
				squareList[column][row].setLegalSquare(false);
			}
		}
	}

	public void moveTo(int column, int row) {

		Piece lastPressedPiece = lastPressedSquare.getPiece();
		/*if (!lastPressedPiece.isHasMoved()) {
			lastPressedPiece.setHasMoved(true);
		}*/
		lastPressedSquare.removeAll();
		squareList[column][row].add(lastPressedPiece);
		
		lastPressedSquare.repaint();
		squareList[column][row].repaint();
		resetSquares();
	}

	public void setLastPressed(int column, int row) {
		lastPressedSquare = squareList[column][row];
	}
	
	public String whoIsInTurn(){
		return playerInTurn;
	}
	
	public void changePlayerInTurn(){
		playerInTurn = (playerInTurn == Marshalling.WHITE) ? Marshalling.BLACK : Marshalling.WHITE;
	}

}
