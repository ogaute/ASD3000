package logicpiece;
import java.util.ArrayList;

import gui.Square;

public class PawnLogic extends PieceLogic {
	
	ArrayList<Square> possibleMove = new ArrayList<Square>();
	
	public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c){
		boolean playerColor = c;
		possibleMove.clear();
		
		System.out.println("x og y: " + x + " " + y);
		/*
		if(state[x-1][y].getPiece()==null){
			System.out.println(x + " " + y);
			possibleMove.add(state[x-1][y]);
		}*/
		
		if (playerColor) {
			possibleMove.add(state[x][y+1]);
			if(y == 1)
				possibleMove.add(state[x][y+2]);
			if(state[x-1][y+1].HasChild()){
				if(playerColor != state[x-1][y+1].getPiece().getPlayerColor()){
					possibleMove.add(state[x-1][y+1]);
				}
			}
			if(state[x+1][y+1].HasChild()){
				if(playerColor != state[x+1][y+1].getPiece().getPlayerColor()){
					possibleMove.add(state[x+1][y+1]);
				}
			}
		} else {
			possibleMove.add(state[x][y-1]);
			if(y == 6)
				possibleMove.add(state[x][y-2]);
			if(state[x-1][y-1].HasChild()){
				if(playerColor != state[x-1][y-1].getPiece().getPlayerColor()){
					possibleMove.add(state[x-1][y-1]);
				}
			}
			if(state[x+1][y-1].HasChild()){
				if(playerColor != state[x+1][y-1].getPiece().getPlayerColor()){
					possibleMove.add(state[x+1][y-1]);
				}
			}
		}

		return possibleMove;
		
	}

}
