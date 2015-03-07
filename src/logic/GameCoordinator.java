package logic;

import gui.ChessBoard;
import gui.ApplicationConstants;
import gui.Square;
import gui.pieceGui.*;
import stockfish.FENgenerator;
import stockfish.LegalMoveValidator;
import java.util.Observable;
import java.util.Observer;
import controller.Controller;

public class GameCoordinator implements Observer {


	private Square[][] squareList;
	private Square lastPressedSquare;
	private String legalMovesFromStockfish = "";
	private LegalMoveValidator legalMoveValidator = new LegalMoveValidator();
	private FENgenerator fenGenerator; //observer
	private PlayerCoordinator playerCoordinator = new PlayerCoordinator();
	private GameHistoryMaker gameHistoryMaker;
	private Promoter promoter = new Promoter();
	
	public GameCoordinator(ChessBoard board) {
		squareList = board.addPieces();
		fenGenerator = new FENgenerator(this);
        fenGenerator.generateFEN(squareList);
        gameHistoryMaker = new GameHistoryMaker(board, squareList);
		gameHistoryMaker.saveState();
	}

	public boolean canIMoveTo(int column, int row) {
		boolean canMove = false;
		String uppercaseSymbol = lastPressedSquare.getPiece().getFENSymbol().toUpperCase();
		if(legalMoveValidator.isLegalForStockfish(column, row, uppercaseSymbol)){
			canMove = true;
			squareList[column][row].setLegalSquare(true);
		}
		return canMove;
	}
	
	public boolean canICapture(int toColumn, int toRow) {
		boolean canCapture = false;
		if(legalMoveValidator.isPawnCaptureLegalForStockfish(toColumn, toRow)){
			canCapture = true;
			squareList[toColumn][toRow].setLegalSquare(true);
		}
		return canCapture;
	}
	
	public void resetSquares(){
		for (int row = 0; row <= ApplicationConstants.NUMCOLUMNS; row++) {
			for (int column = 0; column <= ApplicationConstants.NUMROWS; column++) {
				squareList[column][row].setLegalSquare(false);
			}
		}
	}

	public void moveTo(int column, int row) {
		Piece lastPressedPiece = lastPressedSquare.getPiece();
		lastPressedSquare.removeAll();
		squareList[column][row].add(lastPressedPiece);
		lastPressedSquare.repaint();

		if(promoter.isItTimeForPromotion(row, lastPressedPiece.getFENSymbol()))
			squareList[column][row].add(promoter.getPromoted(lastPressedPiece.getFENSymbol()));

        squareList[column][row].repaint();
        resetSquares();
		gameHistoryMaker.saveState();
	}

	public void setLastPressed(int column, int row) {
		lastPressedSquare = squareList[column][row];
	}
	
	public String whoIsInTurn(){
		return playerCoordinator.whoIsInTurn();
	}
	
	public void changePlayerInTurn(){
		playerCoordinator.changePlayerInTurn();
		fenGenerator.generateFEN(squareList);
	}

	@Override
	public void update(Observable arg0, Object stockFishInfo) {
		legalMovesFromStockfish = ((String[])stockFishInfo)[2];
		String trimedLegalMoves = legalMovesFromStockfish.replaceAll("\\s+","");
		if(trimedLegalMoves == null || trimedLegalMoves.equals("") || trimedLegalMoves.endsWith(" ")){
			Controller.checkMate();
		}
		legalMoveValidator.setlegalMovesFromStockfish(legalMovesFromStockfish);
		System.out.println(legalMovesFromStockfish);
	}

	public String whoWon() {
		return playerCoordinator.whoWon();
	}

	public void undoMove() {
		gameHistoryMaker.undo();
	}

	public void redoMove() {
		gameHistoryMaker.redo();
	}


}
