package stockfish;

import gui.Marshalling;

import java.util.ArrayList;

public class LegalMoveValidator {
	
	private String legalMovesFromStockfish = "";
	
	public void setlegalMovesFromStockfish(String legalMovesFromStockfish){
		this.legalMovesFromStockfish = legalMovesFromStockfish;
	}

	public boolean isLegalForStockfish(int column, int row, String FENSymbol){
		boolean isLegal = false;
		String coordinate = Marshalling.COORDINATES[row][column];
		System.out.println(coordinate);

		String[] splitedLegalMoves = legalMovesFromStockfish.split(" ");
		
		for (int i = 0; i < splitedLegalMoves.length; i++) {
			
			if(splitedLegalMoves[i].matches("(^[a-h]{1}[1-8]{1}[^+])")){
				System.out.println("matches");
				if(coordinate == splitedLegalMoves[i]){
					isLegal = true;
					System.out.println(coordinate + " is legal move");
					break;
				}
			}
			
		}
		
		return isLegal;
	}
	
}
