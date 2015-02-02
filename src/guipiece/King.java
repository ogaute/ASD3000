package guipiece;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class King extends Piece{
	
	public King(boolean s, String c) {
		if(s){
			setLabel("exit.png");
		}
		else{
			setLabel("save.png");
		}
	}

}
