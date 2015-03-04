package logic.pieceLogic;

import controller.Controller;
import gui.Marshalling;
import logic.OutOfBoardFilter;

public class KnightLogic extends PieceLogic{


	private String pieceColor;

	public KnightLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	private void setPieceProperties(){
		if(pieceColor == Marshalling.BLACK){
			pieceSymbol = Marshalling.SYMBOLBLACKKNIGHT;
		}
		else {
			pieceSymbol = Marshalling.SYMBOLWHITEKNIGHT;
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
