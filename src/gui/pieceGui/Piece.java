package gui.pieceGui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public abstract class Piece extends AbstractButton{

	
	protected Image piecePicture;

	public Piece() {
		super();
	}
	
	public void setImage(String s){
		try {
			piecePicture = ImageIO.read(new File(s));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		int x = (this.getWidth() - piecePicture.getWidth(null)) / 2;
	    int y = (this.getHeight() - piecePicture.getHeight(null)) / 2;
		g.drawImage(piecePicture, x, y, null);
	}
	
	public abstract String getFENSymbol();

	public abstract void pressed(int column, int row);
	

}




