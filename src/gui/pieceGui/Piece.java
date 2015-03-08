package gui.pieceGui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Klasse Piece er en abstrakt klasse som utvides av de ulike brikkeklassene.
 * Klassen har hansvar for å lese bildefil inn i et Image
 * Utvider klassen Piece som er en AbstractButton.
 */
public abstract class Piece extends AbstractButton{

	
	protected Image piecePicture;

    /**
     * Piece<p>
     * Konstruktør til abstrakt klasse
     */
	public Piece() {
		super();
	}

    /**
     * Metode som leser fil med bilde til en Image basert til string parameter
     * @param s string med navn på bilde som skal leses
     */
	public void setImage(String s){
		try {
			piecePicture = ImageIO.read(new File(s));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * Metode som tegner bilde i komponent.
     * Bildets posisjon blir sentrert ved å ta størrelse på abstractbtton minus bildets størrelse delt på to.
     * @param g grafikkontekst til komponent
     */
	@Override
	protected void paintComponent(Graphics g) {
		int x = (this.getWidth() - piecePicture.getWidth(null)) / 2;
	    int y = (this.getHeight() - piecePicture.getHeight(null)) / 2;
		g.drawImage(piecePicture, x, y, null);
	}

    /**
     * Abstrakt metode
     */
	public abstract String getFENSymbol();

    /**
     * Abstrakt metode
     */
	public abstract void pressed(int column, int row);
	

}




