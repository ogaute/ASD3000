package logicpiece;

import gui.Square;

import java.util.ArrayList;
import java.util.Iterator;

public class PieceLogic {
		
	public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c, ArrayList<Square> legaMovesWhenKingInCheck){
		ArrayList<Square> possibleMove = new ArrayList<Square>();
		possibleMove.clear();
		return possibleMove;	
	}
	
	public ArrayList<Square> kingInCheckFilter(ArrayList<Square> legaMovesWhenKingInCheck, ArrayList<Square> possibleMove){
		if(!legaMovesWhenKingInCheck.isEmpty()){
			ArrayList<Square> copy = (ArrayList<Square>)possibleMove.clone();
			for (Iterator iterator = copy.iterator(); iterator.hasNext();) {
				Square squareNormal = (Square) iterator.next();
				if (!legaMovesWhenKingInCheck.contains(squareNormal)) {
					possibleMove.remove(squareNormal);
				}
			}
			//possibleMove = copy;
		}
		
		return possibleMove;
	}

}
