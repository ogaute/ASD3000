package gui.pieceGui;

import logic.pieceLogic.KingLogic;


public class King extends Piece{
	
	private KingLogic kingLogic;
	
	public King(boolean s, String c) {
		if(s){
			setImage("img/Black_King.png");
		}
		else{
			setImage("img/White_King.png");
		}
		this.kingLogic = new KingLogic(c);
		
	}

	@Override
	public String getSymbol() {
		return kingLogic.getPieceSymbol();
	}

}
