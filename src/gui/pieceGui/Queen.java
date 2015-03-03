package gui.pieceGui;

import logic.pieceLogic.QueenLogic;

public class Queen extends Piece {
	
	private QueenLogic queenLogic;

	public Queen(boolean isBlack, String color) {
		if(isBlack){
			setImage("img/Black_Queen.png");
		}
		else{
			setImage("img/White_Queen.png");
		}
		this.queenLogic = new QueenLogic(color);
		
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
