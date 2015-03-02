package logic;

import java.util.Observable;
import java.util.Observer;

import stockfish.FENgenerator;
import stockfish.LegalMoveValidator;
import stockfish.StockFishObservable;
import gui.ChessBoard;
import gui.Marshalling;
import gui.Square;
import gui.pieceGui.Piece;

public class ChessCoordinator implements Observer {
	private Square[][] squareList;
	private Square lastPressedSquare;
	private String playerInTurn = Marshalling.WHITE;
	private String legalMovesFromStockfish = "";
	private LegalMoveValidator legalMoveValidator = new LegalMoveValidator();
	
	private FENgenerator fenG = new FENgenerator(); //observer
	private StockFishObservable sfo; //observer
	
	public ChessCoordinator(ChessBoard board) {
		squareList = board.addPieces();
		
        sfo = new StockFishObservable(); //observer
        fenG.addObserver(sfo); //observer
        sfo.addObserver(this); //observer
        
        //fenG.generateFEN(squareList);
	}

	public boolean canIMoveTo(int column, int row) {
		boolean canMove = false;
		
		String uppercaseSymbol = lastPressedSquare.getPiece().getFENSymbol().toUpperCase();
		
		if(legalMoveValidator.isLegalForStockfish(column, row, uppercaseSymbol)){
			canMove = true;
			squareList[column][row].setLegalSquare(true);
		}
		System.out.println("asked for " + column + "(c) and " + row +"(r), ansvar:" + canMove);
		
		return canMove;
	}
	
	public void resetSquares(){
		for (int row = 0; row <= Marshalling.NUMCOLUMNS; row++) {
			for (int column = 0; column <= Marshalling.NUMROWS; column++) {
				squareList[column][row].setLegalSquare(false);
			}
		}
	}

	public void moveTo(int column, int row) {

		Piece lastPressedPiece = lastPressedSquare.getPiece();
		/*if (!lastPressedPiece.isHasMoved()) {
			lastPressedPiece.setHasMoved(true);
		}*/
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
		playerInTurn = (playerInTurn == Marshalling.WHITE) ? Marshalling.BLACK : Marshalling.WHITE;
		fenG.generateFEN(squareList);
	}

	@Override
	public void update(Observable arg0, Object stockFishInfo) {
		legalMovesFromStockfish = ((String[])stockFishInfo)[2];
		legalMoveValidator.setlegalMovesFromStockfish(legalMovesFromStockfish);
		System.out.println(legalMovesFromStockfish);
	}

}
