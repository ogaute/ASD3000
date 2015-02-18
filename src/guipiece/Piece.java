package guipiece;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Piece extends AbstractButton{
	
	protected boolean playerColor; //true er svart, false er hvit
	private boolean hasMoved = false;
	public boolean isHasMoved() { return hasMoved; }
	public void setHasMoved(boolean hasMoved) { this.hasMoved = hasMoved; }

	public Piece() {
		super();
		//ImageIcon icon = new ImageIcon("exit.png");
		//JLabel label = new JLabel(icon);
		//add(label);
		//setIcon(icon);
		//setDisabledIcon(icon);
		//setPressedIcon(icon);
		//setVisible(true);
		//repaint();
	}
	
	public void setLabel(String s){
		add(new JLabel(new ImageIcon(s)));
	}
	
	public boolean getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(boolean playerColor) {
		this.playerColor = playerColor;
	}
	
	public abstract char getPieceSymbol();

}




