package logic.pieceLogic;

import logic.OutOfBoardFilter;
import gui.Marshalling;
import controller.Controller;

public class KnightLogic extends PieceLogic{


	private String pieceColor;

	public KnightLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor == Marshalling.BLACK){
			pieceSymbol = "n";
		}
		else {
			pieceSymbol = "N";
		}
	}
	
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			int posColumns[] = { column + 1, column + 1, column + 2, column + 2, column - 1, column - 1, column - 2, column - 2 };
			int posRows[] = { row - 2, row + 2, row - 1, row + 1, row - 2, row + 2, row - 1, row + 1 };
			for (int i = 0; i <= Marshalling.NUMCOLUMNS; i++)
			{
				if(OutOfBoardFilter.isOutOfBoard(posColumns[i], posRows[i]))
					continue;
				Controller.canIMoveTo(posColumns[i], posRows[i]);
			}
			
		}
	}


}
