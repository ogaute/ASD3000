package stockfish;

import gui.ApplicationConstants;

public class LegalMoveValidator {

	
	private String legalMovesFromStockfish = "";

    public void setlegalMovesFromStockfish(String legalMovesFromStockfish){
		this.legalMovesFromStockfish = legalMovesFromStockfish;
	}

	public boolean isLegalForStockfish(int column, int row, String FENSymbol){
		boolean isLegal = false;
		String coordinate = ApplicationConstants.CHESSCOORDINATES[row][column];
		String[] splitedLegalMoves = legalMovesFromStockfish.split(" ");
		
		for (int i = 0; i < splitedLegalMoves.length; i++) {
			// Validerer lovlige trekk for bonde i spillets stilling
			if(splitedLegalMoves[i].matches("[a-h x]*[a-h][1-8][=]*[Q]*[+#]*") && FENSymbol.equals("P")){
				if(splitedLegalMoves[i].contains(coordinate)){
					isLegal = true;
					break;
				}
			}
            // Validerer lovlige trekk for offiserer i spillets stilling
            else if(splitedLegalMoves[i].matches("[BKNRQ][x]*[a-h][1-8][+#]*")){
				if(splitedLegalMoves[i].contains(FENSymbol)&& splitedLegalMoves[i].contains(coordinate) ){
					isLegal = true;
					break;
				}
			}
			
		}
		
		return isLegal;
	}
	// Sjekker om Bonde kan slå til siden
	public boolean isPawnCaptureLegalForStockfish(int column, int row){
		boolean isLegal = false;
		String coordinate = ApplicationConstants.CHESSCOORDINATES[row][column];
		String[] splitedLegalMoves = legalMovesFromStockfish.split(" ");
		
		for (int i = 0; i < splitedLegalMoves.length; i++) {
            // Validerer lovlige trekk for bonde i spillets stilling
            if(splitedLegalMoves[i].matches("^[a-h]{1}[x]{1}[a-h]{1}[1-8]{1}$")){
				if( splitedLegalMoves[i].contains(coordinate) ){
					isLegal = true;
					break;
				}
			}
		}
		return isLegal;
	}


}
