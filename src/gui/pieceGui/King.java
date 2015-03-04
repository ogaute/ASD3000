package gui.pieceGui;

import logic.pieceLogic.KingLogic;


public class King extends Piece{
	
	
	private KingLogic kingLogic;
	private static int num_white_king = 0;
	private static int num_black_king = 0;
	private static King whiteKing = null;
	private static King blackKing = null;
	
	private King(boolean isBlack, String color) {
		if(isBlack){
			setImage("img/Black_King.png");
			num_black_king++;
		}
		else{
			setImage("img/White_King.png");
			num_white_king++;
		}
		this.kingLogic = new KingLogic(color);
	}
	
	public static King getWhiteKingInstance(boolean isBlack, String color){
		if (!isBlack && num_white_king == 0){
			whiteKing = new King(isBlack, color);
		}
		return whiteKing;
	}
	
	public static King getBlackKingInstance(boolean isBlack, String color){
		if (isBlack && num_black_king == 0){
			blackKing = new King(isBlack, color);
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
