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
	public String getSymbol() {
		return bishopLogic.getPieceSymbol();
	}


}
