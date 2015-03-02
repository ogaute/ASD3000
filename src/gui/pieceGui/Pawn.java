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
	public String getSymbol() {
		return pawnLogic.getPieceSymbol();
	}
	




}
