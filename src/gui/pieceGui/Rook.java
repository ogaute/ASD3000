package gui.pieceGui;

import logic.pieceLogic.RookLogic;

public class Rook extends Piece {
	
	private RookLogic rookLogic;

	public Rook(boolean s, String c) {
		if(s){
			setImage("img/Black_Rook.png");
		}
		else{
			setImage("img/White_Rook.png");
		}
		this.rookLogic = new RookLogic(c);
		
	}

	@Override
	public String getSymbol() {
		return rookLogic.getPieceSymbol();
	}


}
