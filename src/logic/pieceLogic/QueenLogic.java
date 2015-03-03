package logic.pieceLogic;

import gui.Marshalling;
import logic.OutOfBoardFilter;
import controller.Controller;

public class QueenLogic extends PieceLogic{


	private String pieceColor;

	public QueenLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

	private void setPieceProperties(){
		if(pieceColor == Marshalling.BLACK){
			pieceSymbol = "q";
		}
		else {
			pieceSymbol = "Q";
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
