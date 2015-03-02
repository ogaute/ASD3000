package gui.pieceGui;


public class King extends Piece{
	
	public King(boolean s, String c) {
		if(s){
			setImage("img/Black_King.png");
		}
		else{
			setImage("img/White_King.png");
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
