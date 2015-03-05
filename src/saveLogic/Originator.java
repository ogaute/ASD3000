package saveLogic;

import gui.pieceGui.Piece;

public class Originator {
	private Piece[][] state;

	public void setState(Piece[][] state) {
		this.state = state;
	}

	public Piece[][] getState() {
		return state;
	}

	public Memento saveStateToMemento() {
		return new Memento(state);
	}

	public void getStateFromMemento(Memento Memento) {
		state = Memento.getState();
	}
}
