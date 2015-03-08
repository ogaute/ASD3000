package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;
import logic.OutOfBoardFilter;

/**
 * Logic klasse for ridder brikker. <p>
 * Tar ansvar for å holde på farge, brikke symbol og se etter lovlige bevegelser ved trykk.
 */
class KnightLogic extends PieceLogic implements PieceMessage{


	private String pieceColor;

    /**
     * Konstruktør, tar i mot hvilken farge brikken skal være.
     * @param pieceColor brikkens farge
     */
	protected KnightLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

    /**
     * Setter egenskaper (symbol) til brikkelogikken basert på fargen til brikken
     */
	private void setPieceProperties(){
		if(pieceColor.equals(ApplicationConstants.BLACK)){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_KNIGHT;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_KNIGHT;
		}
	}

    /**
     * Metode som tar i mot om brikken er presset på gitt kolonne og rad for forflyttning og ser etter
     * lovlige trekk for ridder brikken. Utnytter CoR for å spørre om lovlig trekk.
     * @param column kolonne som brikken er på
     * @param row rad som brikken er på
     */
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			int posColumns[] = { column + 1, column + 1, column + 2, column + 2, column - 1, column - 1, column - 2, column - 2 };
			int posRows[] = { row - 2, row + 2, row - 1, row + 1, row - 2, row + 2, row - 1, row + 1 };
			for (int i = 0; i <= ApplicationConstants.NUMCOLUMNS; i++)
			{
				if(OutOfBoardFilter.isOutOfBoard(posColumns[i], posRows[i]))
					continue;
				Controller.canIMoveTo(posColumns[i], posRows[i]);
			}
			
		}
	}


}
