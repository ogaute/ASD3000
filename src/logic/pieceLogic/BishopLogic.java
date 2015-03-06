package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

class BishopLogic extends PieceLogic implements PieceMessage{


	private String pieceColor;

	protected BishopLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor.equals(ApplicationConstants.BLACK)){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_BISHOP;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_BISHOP;
		}
	}

	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			
			checkNorthEast(column, row, DEFAULTSTEPS);
			checkSouthEast(column, row, DEFAULTSTEPS);
			checkSouthWest(column, row, DEFAULTSTEPS);
			checkNorthWest(column, row, DEFAULTSTEPS);
		}
	}


}
