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

public class Piece extends AbstractButton{

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

}




