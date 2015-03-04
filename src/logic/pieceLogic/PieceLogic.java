package logic.pieceLogic;

import controller.Controller;
import logic.OutOfBoardFilter;

public abstract class PieceLogic {
	

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


    public void checkNorth(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        north = row - 1;
        iteration = 1;
        while(north >= 0 && iteration <= steps )
        {
			toRow = north;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	north--;
        	iteration++;
        }
	}
	
	public void checkNorthEast(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        north = row - 1;
        east = column + 1;
        iteration = 1;
        while(north >= 0 && iteration <= steps )
        {
			toColumn = east;
			toRow = north;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	north--;
        	east++;
        	iteration++;
        }
	}
	
	public void checkEast(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        east = column + 1;
        iteration = 1;
        while(east >= 0 && iteration <= steps)
        {
			toColumn = east;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	east++;
        	iteration++;
        }
	}
	
	public void checkSouthEast(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        east = column + 1;
        south = row + 1;
        iteration = 1;
        while(east >= 0 && iteration <= steps)
        {
			toColumn = east;
			toRow = south;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	east++;
        	south++;
        	iteration++;
        }
	}
	
	public void checkSouth(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        south = row + 1;
        iteration = 1;
        while(south >= 0 && iteration <= steps)
        {
			toRow = south;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	south++;
        	iteration++;
        }
	}
	
	public void checkSouthWest(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
		west = column - 1;
        south = row + 1;
        iteration = 1;
        while(south >= 0 && iteration <= steps)
        {
			toColumn = west;
			toRow = south;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	west--;
			south++;
        	iteration++;
        }
	}
	
	public void checkWest(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
		west = column - 1;
        iteration = 1;
        while(west >= 0 && iteration <= steps)
        {
			toColumn = west;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	west--;
        	iteration++;
        }
	}
	
	public void checkNorthWest(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        west = column - 1;
        north = row - 1;
        iteration = 1;
        while(west >= 0 && iteration <= steps)
        {
			toColumn = west;
			toRow = north;
			Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	west--;
        	north--;
        	iteration++;
        }
	}

    // dette er nødvendig for å generere FEN streng basert på brettets stilling
    public String getFENSymbol(){
        return pieceSymbol;
    }
	
}
