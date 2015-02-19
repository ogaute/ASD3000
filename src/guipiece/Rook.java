package guipiece;

public class Rook extends Piece {

	public Rook(boolean s, String c) {
		this.myColorString = c;
		if(s){
			setLabel("img/Black_Rook.png");
		}
		else{
			setLabel("img/White_Rook.png");
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
	
	@Override
	public String toString() {
		return "Jeg er et tårn og jeg er " + myColorString;
	}

}
