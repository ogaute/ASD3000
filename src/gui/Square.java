package gui;

import gui.pieceGui.Piece;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Controller;

public class Square extends JPanel implements MouseListener{
	
	boolean hasChildren = false;
	int column;
	int row;
	boolean legalSquare = false;
	Border legalBorder = BorderFactory.createLineBorder(Color.green, 4);

	public Square(Color c, int column, int row) {
		setBackground(c);
		addMouseListener(this);
		this.column = column;
		this.row = row;
		setLayout(new BorderLayout());
	}
	
	public boolean hasChild(){
		return hasChildren;
	}
	
	public Piece getPiece(){
		Piece piece = null;
		if (hasChildren) {
			piece = (Piece)getComponent(0);
		}
		
		return piece;
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
		Piece child = getPiece();
		if(isLegalSquare()){
			Controller.moveTo(column, row);
			Controller.changePlayerInTurn();
		}
		else if(child != null){
			Controller.resetSquares();
			Controller.setLastPressed(column, row);
			child.pressed(column, row);
		}
		else
			Controller.resetSquares();
		
	}

	public boolean isLegalSquare() {
		return legalSquare;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setLegalSquare(boolean b){
		legalSquare = b;
		repaint();
	}
	
	@Override
	public void repaint() {
		//System.out.println("repaint");
		super.repaint();
		if(legalSquare){
			this.setBorder(legalBorder);
		}
		else
			this.setBorder(null);
	}

	
}
