package logicpiece;

import java.util.ArrayList;
import java.util.Iterator;

import controller.Controller;

import gui.Square;
import guipiece.Marshalling;

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
		
		if(!whoIsInControll.isEmpty()){
			ArrayList<Square> legalMoves = legalMovesWhenKingInCheck(state, king, whoIsInControll);
			for (Iterator iterator = legalMoves.iterator(); iterator.hasNext();) {
				Square square = (Square) iterator.next();
				System.out.println("Checler: " + Marshalling.COORDINATES[square.getIndexY()][square.getIndexX()]);
			}
			return true;
		}
		
		return false;
	}
	
	public ArrayList<PieceInControll> isInControll(Square[][] state, Square destination){
		ArrayList<Square> legal = null;
		ArrayList<PieceInControll> piecesInControll = new ArrayList<PieceInControll>();
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if(state[j][i].getPiece() != null && Controller.turn() != state[j][i].getPiece().getPlayerColor()){
					System.out.println(state[j][i].getPiece().toString());
					legal = Controller.canIMove(
							state[j][i].getPiece(), 
							state, 
							state[j][i].getIndexX(), 
							state[j][i].getIndexY(), 
							state[j][i].getPiece().getPlayerColor());
					if(legal != null){
						
						for (Iterator iterator = legal.iterator(); iterator.hasNext();) {
							Square controlledSquare = (Square) iterator.next();
							
							//System.out.println("Destination: " + destination.getIndexX() + " " + destination.getIndexY());
							System.out.println("A legal move: " + controlledSquare.getIndexX() + " " + controlledSquare.getIndexY());
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
			System.out.println("1");
			kingX = kingSquare.getIndexX();
			kingY = kingSquare.getIndexY();
			pieceX = pieceInControll.getPieceInControll().getIndexX();
			pieceY = pieceInControll.getPieceInControll().getIndexY();
			
			if(kingX == pieceX || kingY == pieceY){
				//sjekker om brikker har samme x index, vertikal
				System.out.println("18");
				if(kingX == pieceX){
					System.out.println("19");
					//sjekker om kongen står nedenfor brikke som truer
					if(kingY > pieceY){
						System.out.println("20");
						for(int i=kingY-1;i>=pieceY;i--){
							System.out.println("21");
							listOfLegalMovesWhenKingInCheck.add(state[kingX][i]);
						}
					}
					//hvis kongen står ovenfor brikke som truer
					else{
						System.out.println("22");
						for(int i=kingY+1;i<=pieceY;i++){
							System.out.println("23");
							listOfLegalMovesWhenKingInCheck.add(state[kingX][i]);
						}
					}
				}
				//sjekker om brikker har samme y index, horisontal
				else if(kingY == pieceY){
					System.out.println("24");
					//sjekker om kongen står til høyre for brikke som truer
					if(kingX > pieceX){
						System.out.println("25");
						for(int i=kingX-1;i>=pieceX;i--){
							System.out.println("26");
							listOfLegalMovesWhenKingInCheck.add(state[i][kingY]);
						}
					}
					//hvis kongen står til venstre for brikke som truer
					else{
						System.out.println("27");
						for(int i=kingX+1;i<=pieceX;i++){
							System.out.println("28");
							listOfLegalMovesWhenKingInCheck.add(state[i][kingY]);
						}
					}
				}
			}
			else if( isDiagonal(kingX + pieceX, kingY + pieceY) )
			{
				System.out.println("3");
				//sjekke alle tilfeller hvor konger står til høyre
				if(kingX > pieceX){
					System.out.println("4");
					//sjekke om kongen står nedenfor
					if(kingY < pieceY){
						System.out.println("5");
						int numSquares = pieceY - kingY;
						for(int i=1;i<=numSquares;i++){
							listOfLegalMovesWhenKingInCheck.add(state[kingX-i][kingY+i]);
						}
					}
					else{
						System.out.println("8");
						int numSquares = kingY - pieceY;
						for(int i=1;i<=numSquares;i++){
							listOfLegalMovesWhenKingInCheck.add(state[kingX-i][kingY-i]);
						}
					}
				}
				else{
					System.out.println("11");
					if(kingY < pieceY){
						System.out.println("12");
						int numSquares = pieceY - kingY;
						for(int i=1;i<=numSquares;i++){
							listOfLegalMovesWhenKingInCheck.add(state[kingX+i][kingY+i]);
						}
					}
					else{
						System.out.println("15");
						int numSquares = kingY - pieceY;
						for(int i=1;i<=numSquares;i++){
							listOfLegalMovesWhenKingInCheck.add(state[kingX+i][kingY-i]);
						}

					}
				}
			}
			else{
				System.out.println("2");
				listOfLegalMovesWhenKingInCheck.add(state[pieceX][pieceY]);
			}
		}
		
		return listOfLegalMovesWhenKingInCheck;
	}

	private boolean isDiagonal(int xSum, int ySum) {
		boolean diagonal = false;
		if(((xSum - ySum) % 2) == 0){
			diagonal = true;
		}

		return diagonal;
	}
	
	private boolean isKnight(int xSum, int ySum) {
		boolean knight = false;
		if(!(((xSum - ySum) % 2) == 0)){
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
