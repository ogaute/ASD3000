package saveLogic;

import gui.pieceGui.Piece;

public class Memento {
	private Piece[][] state;

	public Memento(Piece[][] state) {
		this.state = state;
	}

	public Piece[][] getState() {
		return state;
	}
}
