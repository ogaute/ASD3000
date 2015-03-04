package logic.pieceLogic;

import controller.Controller;
import gui.Marshalling;

public class QueenLogic extends PieceLogic{


	private String pieceColor;

	public QueenLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

	private void setPieceProperties(){
		if(pieceColor == Marshalling.BLACK){
			pieceSymbol = Marshalling.SYMBOLBLACKQUEEN;
		}
		else {
			pieceSymbol = Marshalling.SYMBOLWHITEQUEEN;
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
