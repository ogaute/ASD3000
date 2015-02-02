package logicpiece;
import java.util.ArrayList;

import gui.Square;

public class PawnLogic extends PieceLogic {
	
	boolean playerColor;
	Square[][] currentState;
	ArrayList<Square> possibleMove = new ArrayList<Square>();
	
	public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c){
		this.playerColor = c;
		possibleMove.clear();
		
		if(state[x-1][y].getPiece()==null){
			System.out.println(x + " " + y);
			possibleMove.add(state[x-1][y]);
		}
		
		if (playerColor) {
			if (x == 0)
				return possibleMove;
			if (state[x - 1][y].getPiece() == null) {
				possibleMove.add(state[x - 1][y]);
				if (x == 6) {
					if (state[4][y].getPiece() == null)
						possibleMove.add(state[4][y]);
				}
			}
			if ((y > 0)
					&& (state[x - 1][y - 1].getPiece() != null)
					&& (state[x - 1][y - 1].getPiece().getPlayerColor() != this.playerColor))
				possibleMove.add(state[x - 1][y - 1]);
			if ((y < 7)
					&& (state[x - 1][y + 1].getPiece() != null)
					&& (state[x - 1][y + 1].getPiece().getPlayerColor() != this.playerColor))
				possibleMove.add(state[x - 1][y + 1]);
		} else {
			if (x == 8)
				return possibleMove;
			if (state[x + 1][y].getPiece() == null) {
				possibleMove.add(state[x + 1][y]);
				if (x == 1) {
					if (state[3][y].getPiece() == null)
						possibleMove.add(state[3][y]);
				}
			}
			if ((y > 0)
					&& (state[x + 1][y - 1].getPiece() != null)
					&& (state[x + 1][y - 1].getPiece().getPlayerColor() != this.playerColor))
				possibleMove.add(state[x + 1][y - 1]);
			if ((y < 7)
					&& (state[x + 1][y + 1].getPiece() != null)
					&& (state[x + 1][y + 1].getPiece().getPlayerColor() != this.playerColor))
				possibleMove.add(state[x + 1][y + 1]);
		}

		return possibleMove;
		
	}

}
