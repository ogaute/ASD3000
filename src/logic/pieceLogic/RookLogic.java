package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

class RookLogic extends PieceLogic implements PieceMessage{

	
	private String pieceColor;

    /**
     *
     * @param pieceColor
     */
	protected RookLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}

    /**
     *
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
     *
     * @param column
     * @param row
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
