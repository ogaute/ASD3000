package guipiece;

public class Bishop extends Piece {
	
	public Bishop(boolean s, String c) {
		this.myColorString = c;
		if(s){
			setLabel("img/Black_Bishop.png");
		}
		else{
			setLabel("img/White_Bishop.png");
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
	
	@Override
	public String toString() {
		return "Jeg er en løper og jeg er " + myColorString;
	}

}
