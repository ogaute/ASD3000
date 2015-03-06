package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

class PawnLogic extends PieceLogic implements PieceMessage{


	private String pieceColor;
	private int direction;
	private int defaultRow;
	private int passantRow;

	protected PawnLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
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
