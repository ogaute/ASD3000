package gui;


import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Centerpane extends JPanel {

	public Centerpane() {
		setLayout(new BorderLayout());
		add(new ChessBoard());
		
		
		//makeBoard();
		
	}
	/*
	public void makeBoard(){
		int c = 0;
		int index = 0;
		for (int j = 0; j <= 7; j++) {
			for (int i = 0; i <= 7; i++) {
				Square square;
				if (i % 2 == c){
					square = new Square(Color.DARK_GRAY, j, i);
					//System.out.println("Sq " + j + " " + i);
				}
				else {
					square = new Square(Color.LIGHT_GRAY, j, i);
				}
				
				add(square);
				index++;
			}
			if(c == 0){ c = 1; } else{ c = 0;}
		}
	}
*/

}
