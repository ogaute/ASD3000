package gui.pieceGui;

public class Rook extends Piece {

	public Rook(boolean s, String c) {
		if(s){
			setImage("img/Black_Rook.png");
		}
		else{
			setImage("img/White_Rook.png");
		}
		super.setPlayerColor(s);
		
	}

	@Override
	public char getPieceSymbol() {
		if(playerColor)
			return 'r';
		else
			return 'R';
	}

}
