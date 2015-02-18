package gui;

import guipiece.Piece;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Controller;

public class Square extends JPanel implements MouseListener{
	
	boolean hasChildren = false;
	private int indexX;
	public int getIndexX() { return indexX; }
	private int indexY;
	public int getIndexY() { return indexY; }
	boolean legalSquere = false;
	Border redline = BorderFactory.createLineBorder(Color.red, 4);

	public Square(Color c, int indexX, int indexY) {
		setBackground(c);
		addMouseListener(this);
		this.indexX = indexX;
		this.indexY = indexY;
		//System.out.println(indexX + " " + indexY);
	}
	
	public boolean HasChild(){
		return hasChildren;
	}
	
	public Piece getPiece(){
		Piece piece = null;
		if (hasChildren) {
			piece = (Piece)getComponent(0);
		}
		
		return piece;
	}

	public ChessBoard getBoard(){
		return (ChessBoard)getParent();
	}

	@Override
	public void mouseClicked(MouseEvent arg0){

	}
	
	public Component add(Component c){
		super.removeAll();
		super.add(c);
		hasChildren = true;
		return c;
	}
	
	public void remove(Component c){
		super.remove(c);
		super.removeAll();
		hasChildren = false;
	}
	
	public void removeAll(){
		super.removeAll();
		hasChildren = false;
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		Controller.pressed(indexX, indexY);
		/*
		if (hasChildren && Controller.turn() == getPiece().getPlayerColor()) {
			
			if(getBoard().legal != null){
				resetLegalSquare(false);
			}
			//System.out.println(compoenets.toString());
			getBoard().fromX = indexX;
			getBoard().fromY = indexY;
			getBoard().legal = Controller.canIMove(
					getPiece(),
					getBoard().squareList, 
					indexX, 
					indexY, 
					getPiece().getPlayerColor());
			
			resetLegalSquare(true);
			//System.out.println(legal.toString());
		}
		else if(getBoard().legal != null){
			getBoard().toX = indexX;
			getBoard().toY = indexY;
			
			resetLegalSquare(false);
			
			getBoard().move();
		}
		*/	
	}
	/*

	*/
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setLegalSquere(boolean b){
		legalSquere = b;
	}
	
	@Override
	public void repaint() {
		//System.out.println("repaint");
		super.repaint();
		if(legalSquere){
			this.setBorder(redline);
		}
		else
			this.setBorder(null);
	}
	
}
