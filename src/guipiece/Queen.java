package guipiece;

public class Queen extends Piece {

	public Queen(boolean s, String c) {
		this.myColorString = c;
		if(s){
			setLabel("img/Black_Queen.png");
		}
		else{
			setLabel("img/White_Queen.png");
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
	
	@Override
	public String toString() {
		return "Jeg er dronningen og jeg er " + myColorString;
	}

}
