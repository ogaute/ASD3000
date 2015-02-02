package guipiece;

public class Queen extends Piece {

	public Queen(boolean s, String c) {
		if(s){
			setLabel("img/Black_Queen.png");
		}
		else{
			setLabel("img/White_Queen.png");
		}
	}

}
