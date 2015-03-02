package gui.pieceGui;

public class Queen extends Piece {

	public Queen(boolean s, String c) {
		if(s){
			setImage("img/Black_Queen.png");
		}
		else{
			setImage("img/White_Queen.png");
		}
		super.setPlayerColor(s);
		
	}

	@Override
	public char getPieceSymbol() {
		if(playerColor)
			return 'q';
		else
			return 'Q';
	}

}
