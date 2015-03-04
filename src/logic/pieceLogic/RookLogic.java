package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

public class RookLogic extends PieceLogic{

	
	private String pieceColor;

	public RookLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor == ApplicationConstants.BLACK){
			pieceSymbol = ApplicationConstants.SYMBOLBLACKROOK;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOLWHITEROOK;
		}
	}
	
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			
			checkNorth(column, row, DEFAULTSTEPS);
			checkEast(column, row, DEFAULTSTEPS);
			checkSouth(column, row, DEFAULTSTEPS);
			checkWest(column, row, DEFAULTSTEPS);
			
		}
	}


}
