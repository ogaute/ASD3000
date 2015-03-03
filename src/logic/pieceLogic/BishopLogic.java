package logic.pieceLogic;

import controller.Controller;
import gui.Marshalling;

public class BishopLogic extends PieceLogic{


	private String pieceColor;

	public BishopLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor == Marshalling.BLACK){
			pieceSymbol = "b";
		}
		else {
			pieceSymbol = "B";
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
