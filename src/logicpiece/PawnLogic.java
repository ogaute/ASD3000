package logicpiece;
import java.util.ArrayList;
import java.util.Iterator;

import logic.Move;

import controller.Controller;

import gui.Square;

public class PawnLogic extends PieceLogic {
	
	//ArrayList<Square> possibleMove = new ArrayList<Square>();
	
	public ArrayList<Square> whatIHaveControllOver(Square[][] state, int x, int y,  boolean c, ArrayList<Square> legaMovesWhenKingInCheck){
		ArrayList<Square> myControlledSquares = new ArrayList<Square>();
		boolean playerColor = c;
		
		if (playerColor) {
			if(y == 7){
				return myControlledSquares;
			}

			if(x > 0){
				myControlledSquares.add(state[x-1][y+1]);

			}
			if(x < 7){
				myControlledSquares.add(state[x+1][y+1]);

			}
		} else {
			if(y == 0){
				return myControlledSquares;
			}

			if(x > 0){
				myControlledSquares.add(state[x-1][y-1]);

			}
			if(x < 7){
				myControlledSquares.add(state[x+1][y-1]);
			}	
		}

		return myControlledSquares;
	}
	
	public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c, ArrayList<Square> legaMovesWhenKingInCheck){
		ArrayList<Square> possibleMove = new ArrayList<Square>();
		boolean playerColor = c;
		possibleMove.clear();
		
		//System.out.println("x og y: " + x + " " + y);
		/*
		if(state[x-1][y].getPiece()==null){
			System.out.println(x + " " + y);
			possibleMove.add(state[x-1][y]);
		}*/
		
		if (playerColor) {
			if(y == 7){
				return possibleMove;
				//TODO PROMOTION
			}
			//System.out.println("Barn? " + state[x][y+1].HasChild());
			if(!state[x][y+1].HasChild()){
				possibleMove.add(state[x][y+1]);
			}
			if(y == 1 && !state[x][y+2].HasChild())
				possibleMove.add(state[x][y+2]);
			if(x > 0){
				if(state[x-1][y+1].HasChild()){
					if(playerColor != state[x-1][y+1].getPiece().getPlayerColor()){
						possibleMove.add(state[x-1][y+1]);
					}
				}
			}
			if(x < 7){
				if(state[x+1][y+1].HasChild()){
					if(playerColor != state[x+1][y+1].getPiece().getPlayerColor()){
						possibleMove.add(state[x+1][y+1]);
					}
				}
			}
			
			if(y == 4){
				if(x > 0 && state[x-1][y].HasChild() && playerColor != state[x-1][y].getPiece().getPlayerColor()){
					if(Controller.getHistory().enPassantPossible(x-1, y))
						possibleMove.add(state[x-1][y+1]);
				}
				if(x < 7 && state[x+1][y].HasChild() && playerColor != state[x+1][y].getPiece().getPlayerColor()){
					if(Controller.getHistory().enPassantPossible(x+1, y))
						possibleMove.add(state[x+1][y+1]);
				}
			}
			
		} else {
			if(y == 0){
				return possibleMove;
				//TODO PROMOTION
			}
			if(!state[x][y-1].HasChild()){
				possibleMove.add(state[x][y-1]);
			}
			if(y == 6 && !state[x][y-2].HasChild())
				possibleMove.add(state[x][y-2]);
			if(x > 0){
				//System.out.println("x: " + x);
				if(state[x-1][y-1].HasChild()){
					if(playerColor != state[x-1][y-1].getPiece().getPlayerColor()){
						possibleMove.add(state[x-1][y-1]);
					}
				}
			}
			if(x < 7){
				if(state[x+1][y-1].HasChild()){
					if(playerColor != state[x+1][y-1].getPiece().getPlayerColor()){
						possibleMove.add(state[x+1][y-1]);
					}
				}	
			}
			
			if(y == 3){
				if(x > 0 && state[x+1][y].HasChild() && playerColor != state[x+1][y].getPiece().getPlayerColor()){
					if(Controller.getHistory().enPassantPossible(x+1, y))
						possibleMove.add(state[x+1][y-1]);
				}
				if(x < 7 && state[x-1][y].HasChild() && playerColor != state[x-1][y].getPiece().getPlayerColor()){
					if(Controller.getHistory().enPassantPossible(x-1, y))
						possibleMove.add(state[x-1][y-1]);
				}
			}
			
		}
		
		possibleMove = kingInCheckFilter(legaMovesWhenKingInCheck, possibleMove);

		return possibleMove;
		
	}

}
