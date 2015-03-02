package gui.pieceGui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public abstract class Piece extends JButton{
	
	protected Image piecePicture;

	public Piece() {
		super();
		setSize(50, 50);
		repaint();
	}
	
	public void setImage(String s){
		try {
			piecePicture = ImageIO.read(new File(s));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void repaint(Graphics g){
		g.drawImage(piecePicture, 0, 0, null);
	}
	
	public abstract String getSymbol();

}




