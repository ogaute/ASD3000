package logic.pieceLogic;

import controller.Controller;
import gui.Marshalling;

public class KingLogic extends PieceLogic{
    

	private String pieceColor;

	public KingLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor == Marshalling.BLACK){
			pieceSymbol = Marshalling.SYMBOLBLACKKING;
		}
		else {
			pieceSymbol = Marshalling.SYMBOLWHITEKING;
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
