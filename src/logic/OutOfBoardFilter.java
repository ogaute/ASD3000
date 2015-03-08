package logic;

import gui.ApplicationConstants;

/**
 *  Klasse som er ansvarlig for å filtrere bort felt (kolonne, rad) som ligger på utsiden av sjakkbrettet
 */
public class OutOfBoardFilter {

    /**
     * Metode som validerer om en gitt colonne og rad ligger på utsiden av sjakkbrettet
     * @param column kolonne som skal sjekkes
     * @param row rad som skal sjekkes
     * @return om felt er utenfor eller ikke
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
