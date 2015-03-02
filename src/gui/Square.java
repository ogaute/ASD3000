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

public class Square extends JPanel implements MouseListener{
	
	boolean hasChildren = false;
	int indexX;
	int indexY;
	ArrayList<Square> legal = null;
	boolean legalSquere = false;
	Border redline = BorderFactory.createLineBorder(Color.red, 4);

	public Square(Color c, int indexX, int indexY) {
		setBackground(c);
		addMouseListener(this);
		this.indexX = indexX;
		this.indexY = indexY;
		//System.out.println(indexX + " " + indexY);
		setLayout(new BorderLayout());
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
		

		
	}

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
