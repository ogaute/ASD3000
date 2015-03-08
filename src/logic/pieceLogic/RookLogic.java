package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

/**
 * Logic klasse for tårn brikker. <p>
 * Tar ansvar for å holde på farge, brikke symbol og se etter lovlige bevegelser ved trykk.
 */
class RookLogic extends PieceLogic implements PieceMessage{

	
	private String pieceColor;

    /**
     * Konstruktør, tar i mot hvilken farge brikken skal være.
     * @param pieceColor brikkens farge
     */
	protected RookLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

    /**
     * Setter egenskaper (symbol) til brikkelogikken basert på fargen til brikken
     */
	private void setPieceProperties(){
		if(pieceColor.equals(ApplicationConstants.BLACK)){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_ROOK;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_ROOK;
		}
	}

    /**
     * Metode som tar i mot om brikken er presset på gitt kolonne og rad for forflyttning og ser etter
     * lovlige trekk for tårn brikken. 
     * @param column kolonne som brikken er på
     * @param row rad som brikken er på
     */
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			
			checkNorth(column, row, DEFAULTSTEPS);
			checkEast(column, row, DEFAULTSTEPS);
			checkSouth(column, row, DEFAULTSTEPS);
			checkWest(column, row, DEFAULTSTEPS);
			
		}
	}


}
