package gui;


import java.awt.BorderLayout;

import javax.swing.JPanel;

import logic.ChessCoordinator;

public class Centerpane extends JPanel {
	
	private ChessCoordinator coordinator;

	public Centerpane() {
		setLayout(new BorderLayout());
		ChessBoard board;
		add(board = new ChessBoard());
		
		coordinator = new ChessCoordinator(board);
		//makeBoard();
		
	}

	public boolean canIMoveTo(int column, int row) {
		return coordinator.canIMoveTo(column, row);
	}

	public void resetSquares() {
		coordinator.resetSquares();
	}

	public void moveTo(int column, int row) {
		coordinator.moveTo(column, row);
	}

	public void setLastPressed(int column, int row) {
		coordinator.setLastPressed(column, row);
	}

	public void changePlayerInTurn() {
		coordinator.changePlayerInTurn();
	}

	public String getPlayerInTurn() {
		return coordinator.whoIsInTurn();
	}

}
