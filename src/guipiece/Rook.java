package guipiece;

public class Rook extends Piece {

	public Rook(boolean s, String c) {
		if(s){
			setLabel("img/Black_Rook.png");
		}
		else{
			setLabel("img/White_Rook.png");
		}
	}

}
