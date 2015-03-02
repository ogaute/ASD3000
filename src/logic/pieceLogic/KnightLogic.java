package logic.pieceLogic;

import controller.Controller;

public class KnightLogic extends PieceLogic{

	private String pieceColor;
	private String pieceSymbol;
	
	public KnightLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getFENSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "n";
		}
		else {
			pieceSymbol = "N";
		}
	}
	
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			int toColumn = column + 1;
			int toRow = row + 1;
			
			Controller.canIMoveTo(toColumn, toRow);
		}
	}
}
