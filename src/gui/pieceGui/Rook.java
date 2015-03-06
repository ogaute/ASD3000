package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

public class Rook extends Piece {
	
	
	private PieceMessage rookLogic;

	public Rook(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_Rook.png");
			this.rookLogic= new PieceLogicFactory().getPiece("ROOK", ApplicationConstants.BLACK);
			
		}
		else{
			setImage("img/White_Rook.png");
			this.rookLogic = new PieceLogicFactory().getPiece("ROOK", ApplicationConstants.WHITE);
		}
	}

	@Override
	public String getFENSymbol() {
		return rookLogic.getFENSymbol();
	}

	@Override
	public void pressed(int column, int row) {
		rookLogic.pressed(column, row);
	}

	
}
