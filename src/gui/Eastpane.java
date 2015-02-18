package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Eastpane extends JPanel {

	StockFishInfo info;
	
	public Eastpane(){
		info = new StockFishInfo("----Ektra info----");
		//info.setSize(200, 800);
		setPreferredSize(new Dimension(200, 800));
		info.setEditable(false);
		info.setVisible(true);
		add(info);
	}
	
	public StockFishInfo getSFI(){
		return info;
	}
}
