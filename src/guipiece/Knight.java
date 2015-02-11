package guipiece;

public class Knight extends Piece {

	public Knight(boolean s, String c) {
		if(s){
			setLabel("img/Black_Knight.png");
		}
		else{
			setLabel("img/White_Knight.png");
		}
		super.setPlayerColor(s);
	}

	@Override
	public char getPieceSymbol() {
		if(playerColor)
			return 'n';
		else
			return 'N';
	}
}
