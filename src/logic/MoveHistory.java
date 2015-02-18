package logic;

import guipiece.Piece;

import java.util.ArrayList;

public class MoveHistory {

	ArrayList<Move> moveHistory;
	
	public ArrayList<Move> getMoveHistory() { return moveHistory; }

	public void addMove(int fromX, int fromY, int toX, int toY, Piece movedPieced, Piece capturedPiece) { 
		moveHistory.add(new Move(fromX, fromY, toX, toY, movedPieced, capturedPiece));
		System.out.println(moveHistory.get(moveHistory.size() - 1).toString());
	}

	public MoveHistory() {
		moveHistory = new ArrayList<Move>();
	}
} 

class Move{
	private int fromX = 0;
	public int getFromX() { return fromX; }

	private int fromY = 0;
	public int getFromY() { return fromY; }
	
	private int toX = 0;
	public int getToX() { return toX; }
	
	private int toY = 0;
	public int getToY() { return toY; }
	
	private Piece movedPiece = null;
	public Piece getMovedPiece() { return movedPiece; }
	
	private Piece capturedPiece = null;
	public Piece getCapturedPiece() { return capturedPiece; }
	
	public Move(int fromX, int fromY, int toX, int toY, Piece movePieced, Piece capturedPiece) {
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX = toX;
		this.toY = toY;
		this.movedPiece = movePieced;
		this.capturedPiece = capturedPiece;
	}
	
	public String toString(){
		return "Move:" + 
	" from X: " + fromX + 
	", from Y: " + fromY + 
	", to X: " + toX + 
	", to Y: " + toY + 
	", moved piece: " + movedPiece + 
	", captured piece: " + capturedPiece;
		
	}
}
