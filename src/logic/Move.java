package logic;

import guipiece.Piece;

public class Move{
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
	
	private boolean passant = false;
	
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

	public boolean isPassant() {
		return passant;
	}

	public void setPassant(boolean passant) {
		this.passant = passant;
	}
}