package gui;

import guipiece.Marshalling;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ChessBoard extends JPanel {
	
	ArrayList<Square> squareList = new ArrayList<Square>();
	
	public ChessBoard() {
		setLayout(new GridLayout(8,8));
		makeBoard();
		//bare for å teste - SLETT
		squareList.get(1).add(Marshalling.MARSHALLING[0]);
		
	}
	
	public void makeBoard(){
		int c = 0;
		for (int j = 1; j <= 8; j++) {
			for (int i = 1; i <= 8; i++) {
				Square square;
				if (i % 2 == c){
					square = new Square(Color.BLACK);
				}
				else {
					square = new Square(Color.WHITE);
				}
				
				squareList.add(square);
				add(square);
			}
			if(c == 0){ c = 1; } else{ c = 0;}
		}
	}
	
}
