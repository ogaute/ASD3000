package logicpiece;

import gui.Square;

import java.util.ArrayList;

public class KnightLogic extends PieceLogic{

	//ArrayList<Square> possibleMove = new ArrayList<Square>();
	
	public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c){
		boolean playerColor = c;
		possibleMove.clear();
		
		System.out.println("x og y: " + x + " " + y);

		int posx[] = { x + 1, x + 1, x + 2, x + 2, x - 1, x - 1, x - 2, x - 2 };
		int posy[] = { y - 2, y + 2, y - 1, y + 1, y - 2, y + 2, y - 1, y + 1 };
		for (int i = 0; i < 8; i++)
		{
			if ((posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8)){
				if ((state[posx[i]][posy[i]].getPiece() == null || state[posx[i]][posy[i]]
						.getPiece().getPlayerColor() != playerColor)) {
					possibleMove.add(state[posx[i]][posy[i]]);
				}
			}

		}
		
		return possibleMove;
		
	}

}
