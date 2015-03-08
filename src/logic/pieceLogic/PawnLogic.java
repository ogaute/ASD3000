package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

/**
 * Logic klasse for bonde brikker. <p>
 * Tar ansvar for å holde på farge, brikke symbol, forflyttningsretning,
 * standard rad og se etter lovlige bevegelser ved trykk.
 */
class PawnLogic extends PieceLogic implements PieceMessage{


	private String pieceColor;
	private int direction;
	private int defaultRow;
	private int passantRow;

    /**
     * Konstruktør, tar i mot hvilken farge brikken skal være.
     * @param pieceColor brikkens farge
     */
	protected PawnLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

    /**
     * Setter egenskaper (symbol, retning, starndard rad) til brikkelogikken basert på fargen til brikken
     */
	private void setPieceProperties(){
		if(pieceColor.equals(ApplicationConstants.BLACK)){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_PAWN;
			direction = 1;
			defaultRow = 1;
			passantRow = 4;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_PAWN;
			direction = -1;
			defaultRow = 6;
			passantRow = 5;
		}
	}

    /**
     * Metode som tar i mot om brikken er presset på gitt kolonne og rad for forflyttning og ser etter
     * lovlige trekk for bonde brikken. Utnytter CoR for å spørre om lovlig trekk.
     * @param column kolonne som brikken er på
     * @param row rad som brikken er på
     */
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			int toColumn = column;
			int toRow = row + direction;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(row == defaultRow){
				toRow = row + 2*direction;
				Controller.canIMoveTo(toColumn, toRow);
			}
			
			toColumn = column - 1;
			toRow = row + direction;
			Controller.canICapture(toColumn, toRow);
			
			toColumn = column + 1;
			toRow = row + direction;
			Controller.canICapture(toColumn, toRow);
			
			//if(row == passantRow){
				//Controller.enPassant(coumn+1, row+direction);
				//Controller.enPassant(coumn-1, row+direction);
			//}

		}
	}


}
