package gui.pieceGui;

import logic.pieceLogic.KnightLogic;
import logic.pieceLogic.PawnLogic;

public class Knight extends Piece {
	
	private KnightLogic knightLogic;

	public Knight(boolean s, String c) {
		super();
		if(s){
			setImage("img/Black_Knight.png");
		}
		else{
			setImage("img/White_Knight.png");
		}
		this.knightLogic = new KnightLogic(c);
	}

	@Override
	public String getSymbol() {
		return knightLogic.getPieceSymbol();
	}


}
