package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

public class Queen extends Piece {
	
	
	private PieceMessage queenLogic;

	public Queen(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_Queen.png");
			this.queenLogic = new PieceLogicFactory().getPieceLogic("QUEEN", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_Queen.png");
			this.queenLogic = new PieceLogicFactory().getPieceLogic("QUEEN", ApplicationConstants.WHITE);
		}
	}

	@Override
	public String getFENSymbol() {
		return queenLogic.getFENSymbol();
	}

	@Override
	public void pressed(int column, int row) {
		queenLogic.pressed(column, row);
	}
	

}
