package logic.pieceLogic;

import gui.ApplicationConstants;
import controller.Controller;
import logic.OutOfBoardFilter;

/**
 * Abstrakt logic klasse for sjakk brikker generelt. <p>
 * Sjekker lovlige forflyttninger i forskjellige retninger
 * 
 * Klassen bruker Chain of Responsibility mønsteret.
 */
abstract class PieceLogic {
	

    private final int NORTH = -1;
    private final int EAST = +1;
    private final int SOUTH = +1;
    private final int WEST = -1;
    private int iteration;
	private int toColumn;
	private int toRow;
	protected final int DEFAULTSTEPS = ApplicationConstants.DEFAULTSTEPS;
	protected final int KINGSTEPS = ApplicationConstants.KINGSTEPS;
    protected String pieceSymbol;
    private boolean canMove = false;
    
    /**
    * Sjekker en gitt retning basert på kolonne, rad, antall trinn, og gitt retning
    * 
    * @param column kolonnen hvor brikken står
    * @param row raden hvor brikken står
    * @param steps antall trinn som man skal gå i en gitt retning
    * @param firstDirection retning man skal gå i kolonnen
    * @param secondDirection retning man skal gå i raden
    * @return returnerer true vis man kan gå i denne retingen
    */
    private boolean checkDirection(int column, int row, int steps, int firstDirection, int secondDirection){
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
     * 
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
    protected boolean checkNorth(int column, int row, int steps){
        return checkDirection(column, row, steps, 0, NORTH);
	}

    /**
     * Sjekker nordøst retningen
     * 
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkNorthEast(int column, int row, int steps){	
        return checkDirection(column, row, steps, EAST, NORTH);
	}

    /**
     * Sjekker øst retningen
     * 
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkEast(int column, int row, int steps){	
        return checkDirection(column, row, steps, EAST, 0);
	}

    /**
     * Sjekker sørøst retningen
     * 
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkSouthEast(int column, int row, int steps){
        return checkDirection(column, row, steps, EAST, SOUTH);
	}

    /**
     * Sjekker sør retningen
     * 
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkSouth(int column, int row, int steps){
        return checkDirection(column, row, steps, 0, SOUTH);
	}

    /**
     * Sjekker sørvest retningen
     * 
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkSouthWest(int column, int row, int steps){
        return checkDirection(column, row, steps, WEST, SOUTH);
	}

    /**
     * Sjekker vest retningen
     * 
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkWest(int column, int row, int steps){
        return checkDirection(column, row, steps, WEST, 0);
	}

    /**
     * Sjekker nordvest retningen
     * 
     * @param column kolonne brikken står i
     * @param row raden brikken står i
     * @param steps antall trinn som man skal gå i en gitt retning
     * @return returnerer true vis man kan gå i denne retingen
     */
	public boolean checkNorthWest(int column, int row, int steps){
        return checkDirection(column, row, steps, WEST, NORTH);
	}

    /**
     * Henter brikkens FEN-symbol som er nødvendig for å generere en FEN-streng
     * 
     * @return Returnerer brikkens FEN-symbol.
     */
    public String getFENSymbol(){
        return pieceSymbol;
    }
	
}
