package gui.pieceGui;

import logic.pieceLogic.RookLogic;

public class Rook extends Piece {
	
	private RookLogic rookLogic;

	public Rook(boolean isBlack, String color) {
		if(isBlack){
			setImage("img/Black_Rook.png");
		}
		else{
			setImage("img/White_Rook.png");
		}
		this.rookLogic = new RookLogic(color);
		
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
