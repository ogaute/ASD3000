package gui;

import guipiece.Piece;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;

public class Square extends JPanel implements MouseListener{
	
	boolean hasChildren = false;
	int indexX;
	int indexY;
	ArrayList<Square> legal = null;

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

		if (hasChildren && Controller.turn() == getPiece().getPlayerColor()) {
			Component compoenets = getComponent(0);
			System.out.println(compoenets.toString());
			getBoard().fromX = indexX;
			getBoard().fromY = indexY;
			legal = Controller.canIMove(
					getPiece(),
					getBoard().squareList, 
					indexX, 
					indexY, 
					getPiece().getPlayerColor());
			//System.out.println(legal.toString());
		}
		else{
			getBoard().toX = indexX;
			getBoard().toY = indexY;
		}
			
		getBoard().move(legal);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
