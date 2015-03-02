package gui.pieceGui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Piece extends AbstractButton{
	
	protected Image piecePicture;
	protected boolean playerColor; //true er svart, false er hvit

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
	
	
	public void setImage(String s){
		try {
			URL url = new URL(s);
			piecePicture = ImageIO.read(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(boolean playerColor) {
		this.playerColor = playerColor;
	}
	
	
	
	public void repaint(Graphics g){
		g.drawImage(piecePicture,0,0,null);
	}

}




