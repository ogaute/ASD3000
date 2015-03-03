package logic.pieceLogic;

import controller.Controller;

public class KingLogic extends PieceLogic{

	private String pieceColor;
	private String pieceSymbol;
	
	public KingLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getFENSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "k";
		}
		else {
			pieceSymbol = "K";
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
