package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

public class StockFishInfo extends JTextArea implements Observer {

	public StockFishInfo(String string) {
		super(string);// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setText((String)arg1);
		repaint();
		
	}

	

}
