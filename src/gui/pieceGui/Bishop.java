package gui.pieceGui;

import logic.pieceLogic.BishopLogic;

public class Bishop extends Piece {
	
	private BishopLogic bishopLogic;
	
	public Bishop(boolean s, String c) {
		if(s){
			setImage("img/Black_Bishop.png");
		}
		else{
			setImage("img/White_Bishop.png");
		}
		this.bishopLogic = new BishopLogic(c);
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