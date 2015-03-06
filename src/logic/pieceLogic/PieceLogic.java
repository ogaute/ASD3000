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
    private boolean canMove = false;


    public boolean checkNorth(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        north = row - 1;
        iteration = 1;
        while(north >= 0 && iteration <= steps )
        {
			toRow = north;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	north--;
        	iteration++;
        }
        return canMove;
	}
	
	public boolean checkNorthEast(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        north = row - 1;
        east = column + 1;
        iteration = 1;
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
        }
        return canMove;
	}
	
	public boolean checkEast(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        east = column + 1;
        iteration = 1;
        while(east >= 0 && iteration <= steps)
        {
			toColumn = east;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	east++;
        	iteration++;
        }
        return canMove;
	}
	
	public boolean checkSouthEast(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        east = column + 1;
        south = row + 1;
        iteration = 1;
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
        }
        return canMove;
	}
	
	public boolean checkSouth(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        south = row + 1;
        iteration = 1;
        while(south >= 0 && iteration <= steps)
        {
			toRow = south;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	south++;
        	iteration++;
        }
        return canMove;
	}
	
	public boolean checkSouthWest(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
		west = column - 1;
        south = row + 1;
        iteration = 1;
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
        }
        return canMove;
	}
	
	public boolean checkWest(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
		west = column - 1;
        iteration = 1;
        while(west >= 0 && iteration <= steps)
        {
			toColumn = west;
			canMove = Controller.canIMoveTo(toColumn, toRow);
			
			if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
				break;
			
        	west--;
        	iteration++;
        }
        return canMove;
	}
	
	public boolean checkNorthWest(int column, int row, int steps){
		toColumn = column;
		toRow = row;
		
        west = column - 1;
        north = row - 1;
        iteration = 1;
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
        }
        return canMove;
	}

    // dette er nødvendig for å generere FEN streng basert på brettets stilling
    public String getFENSymbol(){
        return pieceSymbol;
    }
	
}
