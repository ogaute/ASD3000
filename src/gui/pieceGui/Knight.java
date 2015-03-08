package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;

public class Knight extends Piece {
	
	
	private PieceMessage knightLogic;

	public Knight(boolean isBlack) {
		super();
		if(isBlack){
			setImage("img/Black_Knight.png");
			this.knightLogic = new PieceLogicFactory().getPieceLogic("KNIGHT", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_Knight.png");
			this.knightLogic = new PieceLogicFactory().getPieceLogic("KNIGHT", ApplicationConstants.WHITE);
		}
	}

	@Override
	public String getFENSymbol() {
		return knightLogic.getFENSymbol();
	}

	@Override
	public void pressed(int column, int row) {
		knightLogic.pressed(column, row);
	}

	
}
