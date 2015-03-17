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

/**
 * Klassen GameCoordinator er ansvarlig for å håndtere brikkemarkering og brikkebevegelser,
 * holde oversikt over lovlige trekk i spillets stilling og sende meldinger videre i systemet
 * Imlementerer pattern Observer
 */
public class GameCoordinator implements Observer {


	private Square[][] squareList;
	private Square lastPressedSquare;
	private String legalMovesFromStockfish = "";
	private LegalMoveValidator legalMoveValidator = new LegalMoveValidator();
	private FENgenerator fenGenerator; //observer
	private PlayerCoordinator playerCoordinator = new PlayerCoordinator();
	private GameHistoryMaker gameHistoryMaker;
	private Promoter promoter = new Promoter();

    /**
     * Kontruktør - sender melding om å legge til brikker på ChessBoard som returnerer liste med squares,
     * Instansierer FENgenerator sender melding om å generere FENstring.
     * Lager også GameHistoryMaker som håndterer spillets historikk
     * @param board mottar peker til ChessBoard
     */
	public GameCoordinator(ChessBoard board) {
		squareList = board.addPieces();
		fenGenerator = new FENgenerator(this);
        fenGenerator.generateFEN(squareList);
        gameHistoryMaker = new GameHistoryMaker(board, squareList);
		gameHistoryMaker.saveState();
	}

    /**
     * Metode som som sender en forespørsel om validering av en brikkeforflytning til en spesifikk kolonne og rad
     * Sender melding til square om at brukkeforflytning er lovlig
     * @param column kolonne i sjakkbrett det skal flyttes til
     * @param row rad i sjakkbrett det skal flyttes til
     * @return returnerer om trekk er lovlig eller ikke
     */
	public boolean canIMoveTo(int column, int row) {
		boolean canMove = false;
		String uppercaseSymbol = lastPressedSquare.getPiece().getFENSymbol().toUpperCase();
		if(legalMoveValidator.isLegalForStockfish(column, row, uppercaseSymbol)){
			canMove = true;
			squareList[column][row].setLegalSquare(true);
		}
		return canMove;
	}

    /**
     * Metode som sender en forespørsel om valiering av om en capture, at en bonde kan slå en annen brikke, er lovlig.
     * Sender melding til square om at capture er lovlig
     * @param toColumn kolonne i sjakkbrett hvor det skal slås
     * @param toRow rad i sjakkbrett hvor det skal slås
     * @return
     */
	public boolean canICapture(int toColumn, int toRow) {
		boolean canCapture = false;
		if(legalMoveValidator.isPawnCaptureLegalForStockfish(toColumn, toRow)){
			canCapture = true;
			squareList[toColumn][toRow].setLegalSquare(true);
		}
		return canCapture;
	}

    /**
     * Metode sender melding til square om at markering av lovlig brikkeforflytning ikke lenger er lovlig (resettes)
     */
	public void resetSquares(){
		for (int row = 0; row <= ApplicationConstants.NUMCOLUMNS; row++) {
			for (int column = 0; column <= ApplicationConstants.NUMROWS; column++) {
				squareList[column][row].setLegalSquare(false);
			}
		}
	}

    /**
     * Metode som utfører brikkeforflytning:
     * Sjekker hvilken square som ble trykket på i utgangspunktet og mottar piece som står på denne.
     * Fjerner piece i opprinnelig square og legger piece til ny square i squarelist på kolonne og rad det skal flyttes til.
     * Sjekker også om piece skal promoteres (fra bonde til offiser)
     * Tegner opp ny square og lagerer tilstand i spillet
     * @param column kolonne som brykkerforflytning skal utføres til
     * @param row rad som brykkerforflytning skal utføres til
     */
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

    /**
     * Metode som sette hvilken square det ble trykket på sist
     * @param column kolonne som det ble trykket på sist
     * @param row rad som det ble trykket på sist
     */
	public void setLastPressed(int column, int row) {
		lastPressedSquare = squareList[column][row];
	}

    /**
     * Metode som sender melding til playerCoordinator for å spørre om hvilken spiller som har sin tur
     * @return om det er hvit eller svart sin tur
     */
	public String whoIsInTurn(){
		return playerCoordinator.whoIsInTurn();
	}

    /**
     * Metode som sender melding til playerCoordinator for å endre hvilken spiller som har sin tur
     * Sender også melding om å generere FEN string
     */
	public void changePlayerInTurn(){
		playerCoordinator.changePlayerInTurn();
		fenGenerator.generateFEN(squareList);
	}

    /**
     * Metode som benyttes som en del av Observer pattern. Lytter etter tilstandsendring i objektet stockFishHandler
     * @param arg0 argument som sendes fra objektet som observeres
     * @param stockFishHandler objektet det lyttes på
     */
	@Override
	public void update(Observable arg0, Object stockFishHandler) {
		legalMovesFromStockfish = ((String[])stockFishHandler)[2];
		String trimedLegalMoves = legalMovesFromStockfish.replaceAll("\\s+","");
		if(trimedLegalMoves == null || trimedLegalMoves.equals("") || trimedLegalMoves.endsWith(" ")){
			Controller.checkMate();
		}
		legalMoveValidator.setlegalMovesFromStockfish(legalMovesFromStockfish);

        Controller.addLegalMovesInfo(legalMovesFromStockfish);

    }

    /**
     * Metode som sender melding til playerCoordinator om hvilken spiller om har vunnet spillet
     * @return
     */
	public String whoWon() {
		return playerCoordinator.whoWon();
	}

    /**
     * Metode som sender melding til gameHistorymaMaker om å rulle tilbake et trekk
     */
	public void undoMove() {
		gameHistoryMaker.undo();
	}

    /**
     * Metode som sender melding til gameHistorymaMaker om å gjøre tilbakerullet trekk om igjen
     */
	public void redoMove() {
		gameHistoryMaker.redo();
	}


}
