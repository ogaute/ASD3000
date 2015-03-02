package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

public class ChessBoard extends JPanel {
	
Square[][] squareList = new Square[8][8];
	
	public ChessBoard() {
		setLayout(new GridLayout(8,0));
		setPreferredSize(new Dimension(800, 800));
		setRequestFocusEnabled(false);
		
		makeBoard();
		addPieces();
		
	    addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentResized(ComponentEvent e) {
	        	int W = 1;  
	            int H = 1;  
	            Rectangle b = e.getComponent().getBounds();
	            e.getComponent().setBounds(b.x, b.y, b.width, b.width*H/W);
	        }
	    });
	}
	
	public Square[][] addPieces(){
		for (int y = 0; y <= 1; y++) {
			for (int x = 0; x < 8; x++) {
				squareList[x][y].add(Marshalling.MARSHALLING[y][x]);
			}
		}
		
		for (int y = 6; y <= 7; y++) {
			for (int x = 0; x < 8; x++) {
				squareList[x][y].add(Marshalling.MARSHALLING[y][x]);
			}
		}
		
		return squareList;
	}
	
	private void makeBoard(){
		int c = 0;
		int index = 0;
		for (int y = 0; y <= 7; y++) {
			for (int x = 0; x <= 7; x++) {
				Square square;
				if (x % 2 == c){
					square = new Square(Color.DARK_GRAY, x, y);
					//System.out.println("Sq " + j + " " + i);
					//square.add(new JLabel("M: y: "+ y +", x: " + x));
				}
				else {
					square = new Square(Color.LIGHT_GRAY, x, y);
					//square.add(new JLabel("M: y: "+ y +", x: " + x));
				}
				
				squareList[x][y] = square;
				add(square);
				index++;
			}
			if(c == 0){ c = 1; } else{ c = 0;}
		}
	}
	

	
}
