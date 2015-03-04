package gui;

import controller.Controller;
import gui.pieceGui.Piece;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square extends JPanel implements MouseListener{


	private boolean hasChildren = false;
    private int column;
    private int row;
    private boolean legalSquare = false;
    private Border legalBorder = BorderFactory.createLineBorder(Color.green, 4);

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

	public void setLegalSquare(boolean b){
		legalSquare = b;
		repaint();
	}
	
	@Override
	public void repaint() {
		super.repaint();
		if(legalSquare){
			this.setBorder(legalBorder);
		}
		else
			this.setBorder(null);
	}
    @Override
    public void mouseReleased(MouseEvent arg0) {}
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mouseClicked(MouseEvent arg0){}

	
}
