package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;


/**
 * Logic klasse for dronning brikker. <p>
 * Tar ansvar for å holde på farge, brikke symbol og se etter lovlige bevegelser ved trykk.
 */
class QueenLogic extends PieceLogic implements PieceMessage{


	private String pieceColor;

    /**
     * Konstruktør, tar i mot hvilken farge brikken skal være.
     * @param pieceColor brikkens farge
     */
	protected QueenLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

    /**
     * Setter egenskaper (symbol) til brikkelogikken basert på fargen til brikken
     */
	private void setPieceProperties(){
		if(pieceColor.equals(ApplicationConstants.BLACK)){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_QUEEN;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_QUEEN;
		}
	}

    /**
     * Metode som tar i mot om brikken er presset på gitt kolonne og rad for forflyttning og ser etter
     * lovlige trekk for dronning brikken. 
     * @param column kolonne som brikken er på
     * @param row rad som brikken er på
     */
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			
			checkNorth(column, row, DEFAULTSTEPS);
			checkNorthEast(column, row, DEFAULTSTEPS);
			checkEast(column, row, DEFAULTSTEPS);
			checkSouthEast(column, row, DEFAULTSTEPS);
			checkSouth(column, row, DEFAULTSTEPS);
			checkSouthWest(column, row, DEFAULTSTEPS);
			checkWest(column, row, DEFAULTSTEPS);
			checkNorthWest(column, row, DEFAULTSTEPS);
			
		}
	}


}
