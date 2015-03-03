package logic.pieceLogic;

import controller.Controller;

public class RookLogic extends PieceLogic{
	
	private String pieceColor;
	private String pieceSymbol;
	
	public RookLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getFENSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
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
