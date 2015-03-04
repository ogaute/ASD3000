package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

public class BishopLogic extends PieceLogic{


	private String pieceColor;

	public BishopLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor == ApplicationConstants.BLACK){
			pieceSymbol = ApplicationConstants.SYMBOLBLACKBISHOP;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOLWHITEBISHOP;
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
