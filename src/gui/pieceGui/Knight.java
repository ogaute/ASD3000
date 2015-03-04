package gui.pieceGui;

import logic.pieceLogic.KnightLogic;

public class Knight extends Piece {
	
	private KnightLogic knightLogic;

	public Knight(boolean isBlack, String color) {
		super();
		if(isBlack){
			setImage("img/Black_Knight.png");
		}
		else{
			setImage("img/White_Knight.png");
		}
		this.knightLogic = new KnightLogic(color);
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
