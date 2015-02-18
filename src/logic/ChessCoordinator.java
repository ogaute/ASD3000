package logic;

import java.util.ArrayList;
import java.util.Iterator;

import stockfish.FENgenerator;

import controller.Controller;
import gui.ChessBoard;
import gui.Square;
import guipiece.Piece;

public class ChessCoordinator {

	ChessBoard board;
	public ChessBoard getBoard() { return board; }
	Square[][] squareList;
	ArrayList<Square> legal = null;
	int fromX = 8;
	int fromY = 8;
	int toX = 8;
	int toY = 8;
	PieceMover mover = new PieceMover();
	MoveHistory moveHistory = new MoveHistory();
	
	public ChessCoordinator() { 
		board = new ChessBoard(); 
		squareList = board.addPieces();
		
	}
	
	public void move() {
		if(mover.inspectMove(fromX, fromY, toX, toY, legal, squareList)){

			board.repaint();
		}
		toX = 8;
		toY = 8;
		fromX = 8;
		fromY = 8;
		legal = null;
		
	}

	public void addToHistory() {
		Piece movedPiece = squareList[fromX][fromY].getPiece();
		Piece capturedPiece = squareList[toX][toY].getPiece();
		moveHistory.addMove(fromX, fromY, toX, toY, movedPiece, capturedPiece);
	}

	public void pressed(int x, int y) {
		if (squareList[x][y].HasChild() && Controller.turn() == squareList[x][y].getPiece().getPlayerColor()) {
			
			if(legal != null){
				resetLegalSquare(false);
			}
			//System.out.println(compoenets.toString());
			fromX = x;
			fromY = y;
			legal = Controller.canIMove(
					squareList[x][y].getPiece(),
					squareList, 
					x, 
					y, 
					squareList[x][y].getPiece().getPlayerColor());
			
			resetLegalSquare(true);
			//System.out.println(legal.toString());
		}
		else if(legal != null){
			toX = x;
			toY = y;
			
			resetLegalSquare(false);
			
			move();
		}
	}

	private void resetLegalSquare(boolean resetLegal){
		for (Iterator iterator = legal.iterator(); iterator.hasNext();) {
			Square legalMove = (Square) iterator.next();
			legalMove.setLegalSquere(resetLegal);
			legalMove.repaint();
		}
	}

}
