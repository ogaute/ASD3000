package gui;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Eastpane extends JPanel {

	StockFishInfo info;
	
	public Eastpane(){
		add(info = new StockFishInfo("Hei"));
		//info.setSize(200, 800);
		info.setPreferredSize(new Dimension(200, 800));
		info.setEditable(false);
		info.setVisible(true);
		
	}
	
	public StockFishInfo getSFI(){
		return info;
	}
}
