package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

public class Pawn extends Piece {
	
	
	private PieceMessage pawnLogic;
	
	public Pawn(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_Pawn.png");
			this.pawnLogic = new PieceLogicFactory().getPiece("PAWN", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_Pawn.png");
			this.pawnLogic = new PieceLogicFactory().getPiece("PAWN", ApplicationConstants.WHITE);
		}
	}

	@Override
	public String getFENSymbol() {
		return pawnLogic.getFENSymbol();
	}

	@Override
	public void pressed(int column, int row) {
		pawnLogic.pressed(column, row);
	}
	

}
