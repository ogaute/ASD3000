package gui;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel {


	Square[][] squareList = new Square[8][8];
	
	public ChessBoard() {
		setLayout(new GridLayout(8,0));
		setPreferredSize(new Dimension(800, 800));
		setRequestFocusEnabled(false);
		makeBoard();
	}
	
	public Square[][] addPieces(){
        // Sorte brikker
		for (int row = 0; row <= 1; row++) {
			for (int column = 0; column <= Marshalling.NUMCOLUMNS; column++) {
				squareList[column][row].add(Marshalling.MARSHALLING[row][column]);
			}
		}
		// hvite brikker
		for (int row = 6; row <= 7; row++) {
			for (int column = 0; column <= Marshalling.NUMCOLUMNS; column++) {
				squareList[column][row].add(Marshalling.MARSHALLING[row][column]);
			}
		}
		
		return squareList;
	}
	
	private void makeBoard(){
		int squareColorChanger = 0;
		for (int row = 0; row <= Marshalling.NUMROWS; row++) {
			for (int column = 0; column <= Marshalling.NUMCOLUMNS; column++) {
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


}
