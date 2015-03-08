package logic.pieceLogic;

import controller.Controller;
import logic.OutOfBoardFilter;

/**
 * Abstrakt logic klasse for sjakk brikker generelt. <p>
 * Sjekker lovlige forflyttninger i forskjellige retninger
 */
abstract class PieceLogic {
	

    private int north;
    private int east;
    private int south;
    private int west;
    private int iteration;
	private int toColumn;
	private int toRow;
	protected final int DEFAULTSTEPS = 7;
	protected final int KINGSTEPS = 1;
    protected String pieceSymbol;
    private boolean canMove = false;
    
    /**
    * Sjekker en gitt retning basert på kolonne, rad, antall trinn, og gitt retning
    * @param column kolonnen hvor brikken står
    * @param row raden hvor brikken står
    * @param steps antall trinn som man skal gå i en gitt retning
    * @param firstDirection retning man skal gå i kolonnen
    * @param secondDirection retning man skal gå i raden
    * @return returnerer true vis man kan gå i denne retingen
    */
    private boolean checkDirection(
    		int column, int row, int steps, int firstDirection, int secondDirection){
        int firstCardinal = column + firstDirection;
        int secondCardinal = row + secondDirection;
        boolean directionCheck = false;
        iteration = 1;
        while(firstCardinal >= 0 && iteration <= steps )
        {
			toColumn = firstCardinal;
			toRow = secondCardinal;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(canMove)
				directionCheck = true;
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
			firstCardinal = firstCardinal + firstDirection;
			secondCardinal = secondCardinal + secondDirection;
        	iteration++;
        }
        return directionCheck;
	}

    /**
     * Sjekker nord retningen
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
    protected boolean checkNorth(int column, int row, int steps){
		toColumn = column;
		toRow = row;
        north = -1;
        /* iteration = 1;
       
        while(north >= 0 && iteration <= steps )
        {
			toRow = north;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	north--;
        	iteration++;
        }*/
        return checkDirection(column, row, steps, 0, north);
	}

    /**
     * Sjekker nordøst retningen
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkNorthEast(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        north = -1;
        east = +1;
        /*iteration = 1;
        while(north >= 0 && iteration <= steps )
        {
			toColumn = east;
			toRow = north;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	north--;
        	east++;
        	iteration++;
        }*/
        return checkDirection(column, row, steps, east, north);
	}

    /**
     * Sjekker øst retningen
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkEast(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        east = +1;
        /*iteration = 1;
        while(east >= 0 && iteration <= steps)
        {
			toColumn = east;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	east++;
        	iteration++;
        }*/
        return checkDirection(column, row, steps, east, 0);
	}

    /**
     * Sjekker sørøst retningen
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkSouthEast(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        east = +1;
        south = +1;
        /*iteration = 1;
        while(east >= 0 && iteration <= steps)
        {
			toColumn = east;
			toRow = south;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	east++;
        	south++;
        	iteration++;
        }*/
        return checkDirection(column, row, steps, east, south);
	}

    /**
     * Sjekker sør retningen
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkSouth(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        south = +1;
        /*iteration = 1;
        while(south >= 0 && iteration <= steps)
        {
			toRow = south;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	south++;
        	iteration++;
        }*/
        return checkDirection(column, row, steps, 0, south);
	}

    /**
     * Sjekker sørvest retningen
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkSouthWest(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
		west = -1;
        south = +1;
        /*iteration = 1;
        while(south >= 0 && iteration <= steps)
        {
			toColumn = west;
			toRow = south;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	west--;
			south++;
        	iteration++;
        }*/
        return checkDirection(column, row, steps, west, south);
	}

    /**
     * Sjekker vest retningen
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkWest(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
		west = -1;
        /*iteration = 1;
        while(west >= 0 && iteration <= steps)
        {
			toColumn = west;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	west--;
        	iteration++;
        }*/
        return checkDirection(column, row, steps, west, 0);
	}

    /**
     * Sjekker nordvest retningen
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkNorthWest(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        west = -1;
        north = -1;
        /*iteration = 1;
        while(west >= 0 && iteration <= steps)
        {
			toColumn = west;
			toRow = north;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	west--;
        	north--;
        	iteration++;
        }*/
        return checkDirection(column, row, steps, west, north);
	}

    /**
     *
     * @return
     */
    // dette er nødvendig for å generere FEN streng basert på brettets stilling
    public String getFENSymbol(){
        return pieceSymbol;
    }
	
}
