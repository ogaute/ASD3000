package gui;

import guipiece.Marshalling;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import controller.Controller;

import logicpiece.PawnLogic;

public class ChessBoard extends JPanel {
	
	Square[][] squareList = new Square[8][8];
	int fromX = 8;
	int fromY = 8;
	int toX = 8;
	int toY = 8;
	
	public ChessBoard() {
		setLayout(new GridLayout(8,8));
		makeBoard();
		//bare for å teste - SLETT
		//squareList.get(4).add(Marshalling.MARSHALLING[4]);
		//squareList.get(60).add(Marshalling.MARSHALLING[60]);
		
		for (int x = 0; x <= 1; x++) {
			for (int y = 0; y < 8; y++) {
				squareList[x][y].add(Marshalling.MARSHALLING[x][y]);
			}
		}
		
		for (int x = 6; x <= 7; x++) {
			for (int y = 0; y < 8; y++) {
				squareList[x][y].add(Marshalling.MARSHALLING[x][y]);
			}
		}
		
	}
	
	public void makeBoard(){
		int c = 0;
		int index = 0;
		for (int j = 0; j <= 7; j++) {
			for (int i = 0; i <= 7; i++) {
				Square square;
				if (i % 2 == c){
					square = new Square(Color.DARK_GRAY, j, i);
				}
				else {
					square = new Square(Color.LIGHT_GRAY, j, i);
				}
				
				squareList[j][i] = square;
				add(square);
				index++;
			}
			if(c == 0){ c = 1; } else{ c = 0;}
		}
	}
	
	public void move(ArrayList<Square> legal){
		if(legal != null){
			if (toX < 8 && fromX < 8 && fromY < 8 && toY < 8){
				
				for (Iterator iterator = legal.iterator(); iterator.hasNext();) {
					Square legalMove = (Square) iterator.next();
					
					if(toY == legalMove.indexY && toX == legalMove.indexX){
						Component c = squareList[fromX][fromY].getComponent(0);
						squareList[fromX][fromY].removeAll();
						squareList[toX][toY].add(c);
						repaint();
						toX = 8;
						toY = 8;
						fromX = 8;
						fromY = 8;
					}
				}
			}
		}
	}
	
}
