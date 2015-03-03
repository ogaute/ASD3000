package logic.pieceLogic;

import controller.Controller;
import gui.Marshalling;

public class RookLogic extends PieceLogic{

	
	private String pieceColor;

	public RookLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor == Marshalling.BLACK){
			pieceSymbol = "r";
		}
		else {
			pieceSymbol = "R";
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
