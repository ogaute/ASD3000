package gui.pieceGui;

public class Knight extends Piece {

	public Knight(boolean s, String c) {
		if(s){
			setImage("img/Black_Knight.png");
		}
		else{
			setImage("img/White_Knight.png");
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
