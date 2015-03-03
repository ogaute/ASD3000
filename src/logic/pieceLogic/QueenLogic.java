package logic.pieceLogic;

import logic.OutOfBoardFilter;
import controller.Controller;

public class QueenLogic extends PieceLogic{
	
	private String pieceColor;
	private String pieceSymbol;
	
	public QueenLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getFENSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "q";
		}
		else {
			pieceSymbol = "Q";
		}
	}
	
	public void pressed(int column, int row) {
		if(pieceColor.equals(Controller.getPlayerInTurn())){
			
			int toColumn = column;
			int toRow = row;
			
	        int north = row - 1;
	        while(north>=0)
	        {
				toColumn = column;
				toRow = north;
				Controller.canIMoveTo(toColumn, toRow);
				
				if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
					break;
				
	        	north--;
	        }
	        
	        north = row - 1;
	        int east = column + 1;
	        while(north>=0)
	        {
				toColumn = east;
				toRow = north;
				Controller.canIMoveTo(toColumn, toRow);
				
				if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
					break;
				
	        	north--;
	        	east++;
	        }
	        
	        east = column + 1;
	        while(east>=0)
	        {
				toColumn = east;
				toRow = row;
				Controller.canIMoveTo(toColumn, toRow);
				
				if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
					break;
				
	        	east++;
	        }
			
	        east = column + 1;
	        int south = row + 1;
	        while(east>=0)
	        {
				toColumn = east;
				toRow = south;
				Controller.canIMoveTo(toColumn, toRow);
				
				if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
					break;
				
	        	east++;
	        	south++;
	        }
	        
	        //south
	        south = row + 1;
	        while(south>=0)
	        {
				toColumn = column;
				toRow = south;
				Controller.canIMoveTo(toColumn, toRow);
				
				if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
					break;
				
	        	south++;
	        }

	        //south west
	        int west = column - 1;
	        south = row + 1;
	        while(south>=0)
	        {
				toColumn = west;
				toRow = south;
				Controller.canIMoveTo(toColumn, toRow);
				
				if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
					break;
				
	        	west--;
				south++;
	        }
	        
	        //west
	        west = column - 1;
	        while(west>=0)
	        {
				toColumn = west;
				toRow = row;
				Controller.canIMoveTo(toColumn, toRow);
				
				if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
					break;
				
	        	west--;
	        }
	        
	        //north west
	        west = column - 1;
	        north = row - 1;
	        while(west>=0)
	        {
				toColumn = west;
				toRow = north;
				Controller.canIMoveTo(toColumn, toRow);
				
				if(OutOfBoardFilter.isOutOfBoard(toColumn, toRow))
					break;
				
	        	west--;
	        	north--;
	        }
			
			//Controller.canIMoveTo(toColumn, toRow);
		}
	}
}
