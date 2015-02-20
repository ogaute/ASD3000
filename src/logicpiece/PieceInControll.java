package logicpiece;

import gui.Square;

import java.util.ArrayList;

public class PieceInControll {
	Square pieceInControll;
	ArrayList<Square> legalMoves = null;
	
	public PieceInControll(Square pieceInControll, ArrayList<Square> legalMoves) {
		this.pieceInControll = pieceInControll;
		this.legalMoves = legalMoves;
	}

	public Square getPieceInControll() { return pieceInControll; }
	public ArrayList<Square> getLegalMoves() { return legalMoves; }
}
