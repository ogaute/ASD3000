package guipiece;

public class Pawn extends Piece {

	public Pawn(boolean s, String c) {
		if(s){
			setLabel("img/Black_Pawn.png");
		}
		else{
			setLabel("img/White_Pawn.png");
		}
		super.setPlayerColor(s);
		
	}
	
	public char getPieceSymbol(){
		if(playerColor)
			return 'p';
		else
			return 'P';
	}



}
