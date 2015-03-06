package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

public class Bishop extends Piece {
	
	
	private PieceMessage bishopLogic;
	
	public Bishop(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_Bishop.png");
			this.bishopLogic = new PieceLogicFactory().getPiece("BISHOP", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_Bishop.png");
			this.bishopLogic = new PieceLogicFactory().getPiece("BISHOP", ApplicationConstants.WHITE);
		}
	}

	@Override
	public String getFENSymbol() {
		return bishopLogic.getFENSymbol();
	}

	@Override
	public void pressed(int column, int row) {
		bishopLogic.pressed(column, row);
	}
	
	
}
