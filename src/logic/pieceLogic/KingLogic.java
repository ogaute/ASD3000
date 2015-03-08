package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

/**
 * Logic klasse for konge brikker. <p>
 * Tar ansvar for å holde på farge, brikke symbol og se etter lovlige bevegelser ved trykk.
 */
class KingLogic extends PieceLogic implements PieceMessage{
    

	private String pieceColor;

    /**
     * Konstruktør, tar i mot hvilken farge brikken skal være.
     * @param pieceColor brikkens farge
     */
	protected KingLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

    /**
     * Setter egenskaper (symbol) til brikkelogikken basert på fargen til brikken
     */
	private void setPieceProperties(){
		if(pieceColor.equals(ApplicationConstants.BLACK)){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_KING;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_KING;
		}
	}

    /**
     * Metode som tar i mot om brikken er presset på gitt kolonne og rad for forflyttning og ser etter
     * lovlige trekk for konge brikken. 
     * @param column kolonne som brikken er på
     * @param row rad som brikken er på
     */
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
