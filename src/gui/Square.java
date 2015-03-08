package gui;

import controller.Controller;
import gui.pieceGui.Piece;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Denne klassen har ansvar for å håndtere egen farge/bord/plassering
 Vite om og håndtere brikker på seg selv
 Lytte på om den blir trykket på og sende melding videre.
 */
public class Square extends JPanel implements MouseListener{


	private boolean hasChildren = false;
    private int column;
    private int row;
    private boolean legalSquare = false;
    private Border legalBorder = BorderFactory.createLineBorder(Color.green, 4);

    /**
     *Konstruktøren til Square, setter utsenden til objektet.
     * @param color bakgrunnsafargen til Square
     * @param column Kolonen Squere tilhører
     * @param row Raden Square tilhører
     */
	public Square(Color color, int column, int row) {
		setBackground(color);
		addMouseListener(this);
		this.column = column;
		this.row = row;
		setLayout(new BorderLayout());
	}

    /**
     *
     * @return returnerer en boolean på om Square har et "barn"
     */
	public boolean hasChild(){
		return hasChildren;
	}

    /**
     *
     * @return en spiller brikke
     */
	public Piece getPiece(){
		Piece piece = null;
		if (hasChildren) {
			piece = (Piece)getComponent(0);
		}
		return piece;
	}

    /**
     * legger til en komponent
     * @param c
     * @return en Komponent
     */
	public Component add(Component c){
		super.removeAll();
		super.add(c);
		hasChildren = true;
		return c;
	}

    /**
     * Fjerner en komponent
     * @param c komponent variabelen
     */
	public void remove(Component c){
		super.remove(c);
		super.removeAll();
		hasChildren = false;
	}

    /**
     *Fjerner alle på brettet
     */
	public void removeAll(){
		super.removeAll();
		hasChildren = false;
	}

    /**
     *Enventhandler for at man har klikket med musen på et felt
     * @param arg0
     */
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

    /**
     *
     * @return at det er et lovlig sted å plasere brikken
     */
	public boolean isLegalSquare() {
		return legalSquare;
	}

    /**
     *
     * @param b en boolean som siere om et felt er lovlig å flytte på eller ikke
     */
	public void setLegalSquare(boolean b){
		legalSquare = b;
		repaint();
	}

    /**
     * tegner den grønne rammen rundt felter som er lovlige trekk.
     */
	@Override
	public void repaint() {
		super.repaint();
		if(legalSquare){
			this.setBorder(legalBorder);
		}
		else
			this.setBorder(null);
	}

    /**
     * Metoder som ikke er i bruk, men må være med da de er en del av implementasjonen av MouseListener
     * @param arg0
     */
    @Override
    public void mouseReleased(MouseEvent arg0) {}
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mouseClicked(MouseEvent arg0){}

	
}
