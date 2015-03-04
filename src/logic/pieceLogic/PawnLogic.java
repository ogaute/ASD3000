package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;

public class PawnLogic extends PieceLogic{


	private String pieceColor;
	private int direction;
	private int defaultRow;

	public PawnLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor == ApplicationConstants.BLACK){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_PAWN;
			direction = 1;
			defaultRow = 1;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_PAWN;
			direction = -1;
			defaultRow = 6;
		}
	}

	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			int toColumn = column;
			int toRow = row + 1*direction;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(row == defaultRow){
				toRow = row + 2*direction;
				Controller.canIMoveTo(toColumn, toRow);
			}
			
			toColumn = column - 1;
			toRow = row + 1*direction;
			Controller.canICapture(toColumn, toRow);
			
			toColumn = column + 1;
			toRow = row + 1*direction;
			Controller.canICapture(toColumn, toRow);

		}
	}


}
