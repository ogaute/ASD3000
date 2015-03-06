package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

class QueenLogic extends PieceLogic implements PieceMessage{


	private String pieceColor;

	protected QueenLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

	private void setPieceProperties(){
		if(pieceColor == ApplicationConstants.BLACK){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_QUEEN;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_QUEEN;
		}
	}
	
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			
			checkNorth(column, row, DEFAULTSTEPS);
			checkNorthEast(column, row, DEFAULTSTEPS);
			checkEast(column, row, DEFAULTSTEPS);
			checkSouthEast(column, row, DEFAULTSTEPS);
			checkSouth(column, row, DEFAULTSTEPS);
			checkSouthWest(column, row, DEFAULTSTEPS);
			checkWest(column, row, DEFAULTSTEPS);
			checkNorthWest(column, row, DEFAULTSTEPS);
			
		}
	}


}
