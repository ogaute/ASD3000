package gui.pieceGui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JButton;

import logic.pieceLogic.PawnLogic;
import logic.pieceLogic.PieceLogic;

public abstract class Piece extends AbstractButton{
	
	protected Image piecePicture;

	public Piece() {
		super();
		//setSize(100, 100);
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
	
	@Override
	protected void paintComponent(Graphics g) {
		//super.paintComponent(arg0);
		int x = (this.getWidth() - piecePicture.getWidth(null)) / 2;
	    int y = (this.getHeight() - piecePicture.getHeight(null)) / 2;
		g.drawImage(piecePicture, x, y, null);
	}
	
	public abstract String getFENSymbol();

	public abstract void pressed(int column, int row);

}




