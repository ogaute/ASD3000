package gui.pieceGui;

import logic.pieceLogic.PawnLogic;

public class Pawn extends Piece {
	
	private PawnLogic pawnLogic;
	
	public Pawn(boolean s, String c) {
		if(s){
			setImage("img/Black_Pawn.png");
		}
		else{
			setImage("img/White_Pawn.png");
		}
		this.pawnLogic = new PawnLogic(c);
		
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
