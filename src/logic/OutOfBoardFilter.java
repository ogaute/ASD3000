package logic;

import gui.Marshalling;

public class OutOfBoardFilter {


	public static boolean isOutOfBoard(int column, int row){
		boolean isOut = true;
		if(column <= Marshalling.NUMCOLUMNS &&
				row <= Marshalling.NUMROWS &&
				column >= 0 && row >= 0)
			isOut = false;
		
		return isOut;
	}


}
