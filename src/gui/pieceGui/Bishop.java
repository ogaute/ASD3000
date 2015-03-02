package gui.pieceGui;

public class Bishop extends Piece {
	
	public Bishop(boolean s, String c) {
		if(s){
			setImage("img/Black_Bishop.png");
		}
		else{
			setImage("img/White_Bishop.png");
		}
		super.setPlayerColor(s);
	}

	@Override
	public char getPieceSymbol() {
		if(playerColor)
			return 'b';
		else
			return 'B';
	}

}
