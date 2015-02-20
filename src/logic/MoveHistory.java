package logic;

import guipiece.Pawn;
import guipiece.Piece;

import java.util.ArrayList;

public class MoveHistory {

	ArrayList<Move> moveHistory;
	public ArrayList<Move> getMoveHistory() { return moveHistory; }

	public void addMove(int fromX, int fromY, int toX, int toY, Piece movedPieced, Piece capturedPiece) { 
		moveHistory.add(new Move(fromX, fromY, toX, toY, movedPieced, capturedPiece));
		//System.out.println(moveHistory.get(moveHistory.size() - 1).toString());
		//getLastHalfMove().setPassant(enPassantPossible(toX, toY));
	}

	public MoveHistory() {
		moveHistory = new ArrayList<Move>();
	}
	
	public Move getLastHalfMove(){
		return moveHistory.get(moveHistory.size()-1);
	}
	
	public boolean enPassantPossible(int x, int y){
		Move lastMove = moveHistory.get(moveHistory.size()-1);
		boolean passant = false;
		
		if(x == lastMove.getToX() && y == lastMove.getToY()){
			if(lastMove.getMovedPiece() instanceof Pawn){
				int sumY = lastMove.getFromY()-lastMove.getToY();
				if( sumY == 2 || sumY == -2){
					passant = true;
				}
			}
		}
		
		return passant;
	}
} 
