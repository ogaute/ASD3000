package guipiece;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class King extends Piece{
	
	public King(boolean s, String c) {
		if(s){
			setLabel("img/Black_King.png");
		}
		else{
			setLabel("img/White_King.png");
		}
		super.setPlayerColor(s);
	}

	@Override
	public char getPieceSymbol() {
		if(playerColor)
			return 'k';
		else
			return 'K';
	}

}
