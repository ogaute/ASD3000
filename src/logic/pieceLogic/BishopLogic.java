package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

/**
 * Logic klasse for løper brikker. <p>
 * Tar ansvar for å holde på farge, brikke symbol og se etter lovlige bevegelser ved trykk.
 */
class BishopLogic extends PieceLogic implements PieceMessage{


	private String pieceColor;

    /**
     * Konstruktør, tar i mot hvilken farge brikken skal være.
     * @param pieceColor brikkens farge
     */
	protected BishopLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

    /**
     * Setter egenskaper (symbol) til brikkelogikken basert på fargen til brikken
     */
	private void setPieceProperties(){
		if(pieceColor.equals(ApplicationConstants.BLACK)){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_BISHOP;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_BISHOP;
		}
	}

    /**
     * Metode som tar i mot om brikken er presset på for forflyttning og ser etter
     * lovlige trekk for løper brikken.
     * @param column kolonne som brikken er på
     * @param row rad som brikken er på
     */
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			
			checkNorthEast(column, row, DEFAULTSTEPS);
			checkSouthEast(column, row, DEFAULTSTEPS);
			checkSouthWest(column, row, DEFAULTSTEPS);
			checkNorthWest(column, row, DEFAULTSTEPS);
		}
	}


}
