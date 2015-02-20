package logic;

import gui.ChessBoard;
import gui.Square;
import guipiece.King;
import guipiece.Marshalling;
import guipiece.Piece;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import controller.Controller;

public class PieceMover {

	public boolean inspectMove(
			int fromX, 
			int fromY, 
			int toX, 
			int toY, 
			ArrayList<Square> legal, 
			Square[][] squareList) {
		boolean repaint = false;
		if (toX < 8 && fromX < 8 && fromY < 8 && toY < 8) {
			for (Iterator iterator = legal.iterator(); iterator.hasNext();) {

				Square legalMove = (Square) iterator.next();
				//System.out.println("Legal move: " + Marshalling.COORDINATES[legalMove.getIndexY()][legalMove.getIndexX()]);

				if (toY == legalMove.getIndexY() && toX == legalMove.getIndexX()) {
					
					isCasteling(fromX, 
							fromY, 
							toX, 
							toY, 
							legal, 
							squareList);
					
					move(fromX, fromY, toX, toY, squareList);
					repaint = true;
					Controller.nextTurn();
					break;
				}
			}
		}
		return repaint;
	}

	//Om konge, ikke flyttet før, rook ikke flyttet, konge ikke i sjakk, konge ikke i sjakk på veien, ikke i sjakk i feltet
	private void isCasteling(int fromX, int fromY, int toX, int toY,
			ArrayList<Square> legal, Square[][] squareList) {
		Piece king = squareList[fromX][fromY].getPiece();
		if(king instanceof King && !king.isHasMoved()){
			if(toX == 2){
				Piece rook = squareList[0][fromY].getPiece();
			}
			
		}
		
	}

	public void move(int fromX, int fromY, int toX, int toY, Square[][] squareList) {
		
		Controller.addToHistory();
		Piece c = squareList[fromX][fromY].getPiece();
		if (!c.isHasMoved()) {
			c.setHasMoved(true);
		}
		squareList[fromX][fromY].removeAll();
		squareList[toX][toY].add(c);
	}
	
}