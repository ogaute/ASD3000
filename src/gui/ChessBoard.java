package gui;

import guipiece.Marshalling;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class ChessBoard extends JPanel {
	
	Square[][] squareList = new Square[8][8];
	ArrayList<Square> legal = null;
	int fromX = 8;
	int fromY = 8;
	int toX = 8;
	int toY = 8;
	
	public ChessBoard() {
		setLayout(new GridLayout(8,0));
		makeBoard();
		//bare for å teste - SLETT
		//squareList.get(4).add(Marshalling.MARSHALLING[4]);
		//squareList.get(60).add(Marshalling.MARSHALLING[60]);
		
		for (int y = 0; y <= 1; y++) {
			for (int x = 0; x < 8; x++) {
				squareList[x][y].add(Marshalling.MARSHALLING[y][x]);
				//squareList[x][y].add(new JLabel("P: y: "+ y +", x: " + x));
			}
		}
		
		for (int y = 6; y <= 7; y++) {
			for (int x = 0; x < 8; x++) {
				squareList[x][y].add(Marshalling.MARSHALLING[y][x]);
				//squareList[x][y].add(new JLabel("P: y: "+ y +", x: " + x));
			}
		}
		
	}
	
	public void makeBoard(){
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
	
	public void move(){
		if(legal != null){
			System.out.println(fromX + " " + fromY + " " + toX + " " + toY);
			if (toX < 8 && fromX < 8 && fromY < 8 && toY < 8){
				//System.out.println(legal.toString());
				for (Iterator iterator = legal.iterator(); iterator.hasNext();) {

					Square legalMove = (Square) iterator.next();
					System.out.println("Legal move: " + legalMove.indexX + " " + legalMove.indexY);
					
					if(toY == legalMove.indexY && toX == legalMove.indexX){
						Component c = squareList[fromX][fromY].getComponent(0);
						squareList[fromX][fromY].removeAll();
						squareList[toX][toY].add(c);
						repaint();
						toX = 8;
						toY = 8;
						fromX = 8;
						fromY = 8;
						legal = null;
						Controller.nextTurn();
					}
				}
			}
		}
	}
	
}
