package logic.pieceLogic;

import gui.Marshalling;

import java.util.ArrayList;

import controller.Controller;

public class PawnLogic extends PieceLogic{

	private String pieceColor;
	private String pieceSymbol;
	private int direction;
	private boolean hasMoved = false;
	//private ArrayList<Point> moveList;
	
	public PawnLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getFENSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "p";
			direction = 1;
		}
		else {
			pieceSymbol = "P";
			direction = -1;
		}
	}

	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			int toColumn = column;
			int toRow = row + 1*direction;
			
			Controller.canIMoveTo(toColumn, toRow);
			
			if(!hasMoved){
				toRow = row + 2*direction;
				
				Controller.canIMoveTo(toColumn, toRow);
				hasMoved = true;
			}
			

		}
	}
	
}
