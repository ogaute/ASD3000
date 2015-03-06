package gui.pieceGui;

import gui.ApplicationConstants;
import logic.pieceLogic.PieceLogicFactory;
import logic.pieceLogic.PieceMessage;


public class King extends Piece{
	
	
	private PieceMessage kingLogic;
	private static int num_white_king = 0;
	private static int num_black_king = 0;
	private static King whiteKing = null;
	private static King blackKing = null;
	
	private King(boolean isBlack) {
		if(isBlack){
			setImage("img/Black_King.png");
			num_black_king++;
			this.kingLogic = new PieceLogicFactory().getPiece("KING", ApplicationConstants.BLACK);
		}
		else{
			setImage("img/White_King.png");
			num_white_king++;
			this.kingLogic = new PieceLogicFactory().getPiece("KING", ApplicationConstants.WHITE);
		}
	}
	
	public static King getWhiteKingInstance(){
		if (num_white_king == 0){
			whiteKing = new King(false);
		}
		return whiteKing;
	}
	
	public static King getBlackKingInstance(){
		if (num_black_king == 0){
			blackKing = new King(true);
		}
		return blackKing;
	}

	@Override
	public String getFENSymbol() {
		return kingLogic.getFENSymbol();
	}

	@Override
	public void pressed(int column, int row) {
		kingLogic.pressed(column, row);
	}
	
	
}
