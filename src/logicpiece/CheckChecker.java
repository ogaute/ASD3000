package logicpiece;

import java.util.ArrayList;
import java.util.Iterator;

import controller.Controller;

import gui.Square;

public class CheckChecker {

	public boolean isKingInCheck(Square[][] state) {
		System.out.println("Hei");
		ArrayList<Square> kings = Controller.getKings();
		Square king = null;
		if(Controller.turn()){
			king = kings.get(0);
		}
		else {
			king = kings.get(1);
		}
		ArrayList<PieceInControll> whoIsInControll = isInControll(state, king);
		ArrayList<Square> legalMoves = legalMovesWhenKingInCheck(state, king, whoIsInControll);
		
		if(whoIsInControll != null){
			return true;
		}
		
		return false;
	}
	
	public ArrayList<PieceInControll> isInControll(Square[][] state, Square destination){
		ArrayList<Square> legal = null;
		ArrayList<PieceInControll> piecesInControll = new ArrayList<PieceInControll>();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if(state[j][i].getPiece() != null && Controller.turn() != state[j][i].getPiece().getPlayerColor()){
					//System.out.println("bye bye");
					legal = Controller.canIMove(
							state[j][i].getPiece(), 
							state, 
							state[j][i].getIndexX(), 
							state[j][i].getIndexY(), 
							state[j][i].getPiece().getPlayerColor());
					if(legal != null){
						for (Iterator iterator = legal.iterator(); iterator.hasNext();) {
							Square controlledSquare = (Square) iterator.next();
							
							if(destination == controlledSquare){
								piecesInControll.add(new PieceInControll(state[j][i], legal));
							}
						}
					}
				}
			}
		}
		
		return piecesInControll;
	}
	
	public ArrayList<Square> legalMovesWhenKingInCheck(Square[][] state, Square kingSquare, ArrayList<PieceInControll> piecesInControll){
		
		ArrayList<Square> listOfLegalMovesWhenKingInCheck = new ArrayList<Square>();
		int kingX = 8;
		int kingY = 8;
		int pieceX = 8;
		int pieceY = 8;
		
		for (Iterator iterator = piecesInControll.iterator(); iterator.hasNext();) {
			PieceInControll pieceInControll = (PieceInControll) iterator.next();
			kingX = kingSquare.getIndexX();
			kingY = kingSquare.getIndexY();
			pieceX = pieceInControll.getPieceInControll().getIndexX();
			pieceY = pieceInControll.getPieceInControll().getIndexY();
			
			if(isKnight(kingX + pieceX, kingY + pieceY)){
				listOfLegalMovesWhenKingInCheck.add(state[pieceX][pieceY]);
			}
			else if( isDiagonal(kingX + pieceX, kingY + pieceY) )
			{
				//sjekke alle tilfeller hvor konger står til høyre
				if(kingX > pieceX){
					//sjekke om kongen står nedenfor
					if(kingY < pieceY){
						for(int i=kingY+1;i<=pieceY;i++){
							for(int j=kingX-1;j>=pieceX;j--){
								listOfLegalMovesWhenKingInCheck.add(state[j][i]);
							}
						}
					}
					else{
						for(int i=kingY-1;i>=pieceY;i--){
							for(int j=kingX-1;j>=pieceX;j--){
								listOfLegalMovesWhenKingInCheck.add(state[j][i]);
							}
						}
					}
				}
				else{
					if(kingY < pieceY){
						for(int i=kingY+1;i<=pieceY;i++){
							for(int j=kingX+1;j<=pieceX;j++){
								listOfLegalMovesWhenKingInCheck.add(state[j][i]);
							}
						}
					}
					else{
						for(int i=kingY-1;i>=pieceY;i--){
							for(int j=kingX+1;j<=pieceX;j++){
								listOfLegalMovesWhenKingInCheck.add(state[j][i]);
							}
						}
					}
				}
			}
			else{
				//sjekker om brikker har samme x index, vertikal
				if(kingX == pieceX){
					//sjekker om kongen står nedenfor brikke som truer
					if(kingY > pieceY){
						for(int i=kingY-1;i>=pieceY;i--){
							listOfLegalMovesWhenKingInCheck.add(state[kingX][i]);
						}
					}
					//hvis kongen står ovenfor brikke som truer
					else{
						for(int i=kingY+1;i<=pieceY;i++){
							listOfLegalMovesWhenKingInCheck.add(state[kingX][i]);
						}
					}
				}
				//sjekker om brikker har samme y index, horisontal
				else if(kingY == pieceY){
					//sjekker om kongen står til høyre for brikke som truer
					if(kingX > pieceX){
						for(int i=kingX-1;i>=pieceX;i--){
							listOfLegalMovesWhenKingInCheck.add(state[i][kingY]);
						}
					}
					//hvis kongen står til venstre for brikke som truer
					else{
						for(int i=kingX+1;i<=pieceX;i++){
							listOfLegalMovesWhenKingInCheck.add(state[i][kingY]);
						}
					}
				}
			}
			//else
		}
		
		return listOfLegalMovesWhenKingInCheck;
	}

	private boolean isDiagonal(int xSum, int ySum) {
		boolean diagonal = false;
		if((xSum - ySum) == 0){
			diagonal = true;
		}

		return diagonal;
	}
	
	private boolean isKnight(int xSum, int ySum) {
		boolean knight = false;
		if((xSum - ySum) == 1 || (xSum - ySum) == -1){
			knight = true;
		}

		return knight;
	}

}

class PieceInControll{
	Square pieceInControll;
	ArrayList<Square> legalMoves = null;
	
	public PieceInControll(Square pieceInControll, ArrayList<Square> legalMoves) {
		this.pieceInControll = pieceInControll;
		this.legalMoves = legalMoves;
	}

	public Square getPieceInControll() { return pieceInControll; }
	public ArrayList<Square> getLegalMoves() { return legalMoves; }
}
