package logic;

import gui.ChessBoard;
import gui.ApplicationConstants;
import gui.Square;
import gui.pieceGui.Piece;
import stockfish.FENgenerator;
import stockfish.LegalMoveValidator;
import stockfish.StockFishObservable;

import java.util.Observable;
import java.util.Observer;

public class ChessCoordinator implements Observer {


	private Square[][] squareList;
	private Square lastPressedSquare;
	private String playerInTurn = ApplicationConstants.WHITE;
	private String legalMovesFromStockfish = "";
	private LegalMoveValidator legalMoveValidator = new LegalMoveValidator();
	private FENgenerator fenGenerator = new FENgenerator(); //observer
	private StockFishObservable stockFishObservable; //observer
	
	public ChessCoordinator(ChessBoard board) {
		squareList = board.addPieces();
		stockFishObservable = new StockFishObservable(); //observer
        fenGenerator.addObserver(stockFishObservable); //observer
        stockFishObservable.addObserver(this); //observer
        fenGenerator.generateFEN(squareList);
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
		squareList[column][row].repaint();
		resetSquares();
	}

	public void setLastPressed(int column, int row) {
		lastPressedSquare = squareList[column][row];
	}
	
	public String whoIsInTurn(){
		return playerInTurn;
	}
	
	public void changePlayerInTurn(){
		playerInTurn = (playerInTurn == ApplicationConstants.WHITE) ? ApplicationConstants.BLACK : ApplicationConstants.WHITE;
		fenGenerator.generateFEN(squareList);
	}

	@Override
	public void update(Observable arg0, Object stockFishInfo) {
		legalMovesFromStockfish = ((String[])stockFishInfo)[2];
		if(legalMovesFromStockfish == null || legalMovesFromStockfish.equals("")){
			
		}
		legalMoveValidator.setlegalMovesFromStockfish(legalMovesFromStockfish);
		System.out.println(legalMovesFromStockfish);
	}


}
