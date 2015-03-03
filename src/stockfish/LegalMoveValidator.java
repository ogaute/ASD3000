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
		//System.out.println(coordinate);

		String[] splitedLegalMoves = legalMovesFromStockfish.split(" ");
		
		for (int i = 0; i < splitedLegalMoves.length; i++) {
			
			if(splitedLegalMoves[i].matches("[a-h][1-8]") && FENSymbol.equals("P")){
				if( coordinate.equals(splitedLegalMoves[i]) ){
					isLegal = true;
					//System.out.println(coordinate + " is legal move - 1");
					break;
				}
			}
			
			else if(splitedLegalMoves[i].matches("[BKNRQ][x]*[a-h][1-8][+#]*")){
				if(splitedLegalMoves[i].contains(FENSymbol)&& splitedLegalMoves[i].contains(coordinate) ){
					isLegal = true;
					//System.out.println(coordinate + " is legal move - 3");
					break;
				}
			}
			
		}
		
		return isLegal;
	}
	
	public boolean isPawnCaptureLegalForStockfish(int column, int row){
		boolean isLegal = false;
		String coordinate = Marshalling.COORDINATES[row][column];
		//System.out.println(coordinate);

		String[] splitedLegalMoves = legalMovesFromStockfish.split(" ");
		
		for (int i = 0; i < splitedLegalMoves.length; i++) {
			if(splitedLegalMoves[i].matches("^[a-h]{1}[x]{1}[a-h]{1}[1-8]{1}$")){
				if( splitedLegalMoves[i].contains(coordinate) ){
					isLegal = true;
					//System.out.println(coordinate + " is legal move - 2");
					break;
				}
			}
		}
		return isLegal;
	}
	
}
