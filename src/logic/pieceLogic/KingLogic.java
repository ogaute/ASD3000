package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

class KingLogic extends PieceLogic implements PieceMessage{
    

	private String pieceColor;

	protected KingLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor == ApplicationConstants.BLACK){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_KING;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_KING;
		}
	}
	
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			
			checkNorth(column, row, KINGSTEPS);
			checkNorthEast(column, row, KINGSTEPS);
			checkEast(column, row, KINGSTEPS);
			checkSouthEast(column, row, KINGSTEPS);
			checkSouth(column, row, KINGSTEPS);
			checkSouthWest(column, row, KINGSTEPS);
			checkWest(column, row, KINGSTEPS);
			checkNorthWest(column, row, KINGSTEPS);
			
		}
	}


}
