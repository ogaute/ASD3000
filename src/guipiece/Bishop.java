package guipiece;

public class Bishop extends Piece {
	
	public Bishop(boolean s, String c) {
		if(s){
			setLabel("img/Black_Bishop.png");
		}
		else{
			setLabel("img/White_Bishop.png");
		}
		super.setPlayerColor(s);
	}

}
