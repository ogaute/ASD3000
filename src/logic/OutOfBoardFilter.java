package logic;

import gui.ApplicationConstants;

public class OutOfBoardFilter {

    /**
     *
     * @param column
     * @param row
     * @return
     */
	public static boolean isOutOfBoard(int column, int row){
		boolean isOut = true;
		if(column <= ApplicationConstants.NUMCOLUMNS &&
				row <= ApplicationConstants.NUMROWS &&
				column >= 0 && row >= 0)
			isOut = false;
		
		return isOut;
	}


}
