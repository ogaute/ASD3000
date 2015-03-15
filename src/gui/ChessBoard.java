package gui;

import gui.pieceGui.Piece;

import javax.swing.*;
import java.awt.*;

/**
 *  Klassen ChessBoard har ansvar for å lage brukergrensesnittelemnter, <p>
 *  håndtering av brilleplaseringer og oppdatering av brukegrensesnittet
 */
public class ChessBoard extends JPanel {


	Square[][] squareList = new Square[8][8];

    /**
     *konstruktøren for Chessboard , har i oppgave sette brukergrensesnittelementer.
     */
	public ChessBoard() {
		setLayout(new GridLayout(8,0));
		setPreferredSize(new Dimension(800, 800));
		setRequestFocusEnabled(false);
		makeBoard();
	}

    /**
     *
     * @return squareList en liste med innholdet
     */
	public Square[][] addPieces(){
        // Sorte brikker
		for (int row = 0; row <= 1; row++) {
			for (int column = 0; column <= ApplicationConstants.NUMCOLUMNS; column++) {
				squareList[column][row].add(ApplicationConstants.MARSHALLING[row][column]);
			}
		}
		// hvite brikker
		for (int row = 6; row <= 7; row++) {
			for (int column = 0; column <= ApplicationConstants.NUMCOLUMNS; column++) {
				squareList[column][row].add(ApplicationConstants.MARSHALLING[row][column]);
			}
		}
		
		return squareList;
	}

    /**
     * metode for å lage selve spill brettet
     */
	private void makeBoard(){
		int squareColorChanger = 0;
		for (int row = 0; row <= ApplicationConstants.NUMROWS; row++) {
			for (int column = 0; column <= ApplicationConstants.NUMCOLUMNS; column++) {
				Square square;
				if (column % 2 == squareColorChanger){
					square = new Square(Color.DARK_GRAY, column, row);
				}
				else {
					square = new Square(Color.LIGHT_GRAY, column, row);
				}
				
				squareList[column][row] = square;
				add(square);

			}
			if(squareColorChanger == 0){ squareColorChanger = 1; } else{ squareColorChanger = 0;}
		}
	}

    /**
     * metode for å fjerne en brikke fra spillet
     */
	public void removePieces(){
		for (int row = 0; row <= ApplicationConstants.NUMROWS; row++) {
			for (int column = 0; column <= ApplicationConstants.NUMCOLUMNS; column++) {
				if(squareList[column][row].hasChild()){
					squareList[column][row].removeAll();
				}
			}
		}
		updateUI();
	}

    /**
     * metode som har i oppgave å forandre brettet når man bruker undo eller redo knappene
     * @param savedPieceList en liste med Brikker som er lagret.
     */
	public void changeGameState(Piece[][] savedPieceList){
		for (int row = 0; row <= ApplicationConstants.NUMROWS; row++) {
			for (int column = 0; column <= ApplicationConstants.NUMCOLUMNS; column++) {
				Piece pieceToAdd = savedPieceList[column][row];
				if(pieceToAdd != null){
					squareList[column][row].add(pieceToAdd);
				}
			}
		}
		updateUI();
	}


}
