package logic.pieceLogic;

import controller.Controller;
import gui.ApplicationConstants;
import logic.OutOfBoardFilter;

class KnightLogic extends PieceLogic implements PieceMessage{


	private String pieceColor;

	protected KnightLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor.equals(ApplicationConstants.BLACK)){
			pieceSymbol = ApplicationConstants.SYMBOL_BLACK_KNIGHT;
		}
		else {
			pieceSymbol = ApplicationConstants.SYMBOL_WHITE_KNIGHT;
		}
	}
	
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
