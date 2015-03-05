package gui;


import logic.ChessCoordinator;

import javax.swing.*;
import java.awt.*;

public class Centerpane extends JPanel {
	
	private ChessCoordinator coordinator;
	JPanel boardPanel;
	JPanel southCoordinates;
	JPanel eastCoordinates;
	JPanel northCoordinates;
	JPanel westCoordinates;

	public Centerpane() {
		setLayout(new BorderLayout());
		ChessBoard board;
		add(board = new ChessBoard());
		makeCoordinates();
		coordinator = new ChessCoordinator(board);
    }

	public void makeCoordinates() {
        southCoordinates = new JPanel();
        southCoordinates.setLayout(new GridLayout(0, 8));
        add(southCoordinates, BorderLayout.SOUTH);

        northCoordinates = new JPanel();
        northCoordinates.setLayout(new GridLayout(0, 8));
        add(northCoordinates, BorderLayout.NORTH);

        eastCoordinates = new JPanel();
        eastCoordinates.setLayout(new GridLayout(8, 0));
        add(eastCoordinates, BorderLayout.EAST);

        westCoordinates = new JPanel();
        westCoordinates.setLayout(new GridLayout(8, 0));
        add(westCoordinates, BorderLayout.WEST);

		String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H" };
		for (int j = 0; j <= 9; j++) {
			if (j != 9 && j != 0) {
				southCoordinates.add(new JLabel(letters[j - 1],
						SwingConstants.CENTER));
				northCoordinates.add(new JLabel(letters[j - 1],
						SwingConstants.CENTER));
				eastCoordinates.add(new JLabel("  " + (9 - j) + "  ",
						SwingConstants.CENTER));
				westCoordinates.add(new JLabel("  " + (9 - j) + "  ",
						SwingConstants.CENTER));
			}
		}
	}

    // CoR meldingsstier
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

	public boolean canICapture(int toColumn, int toRow) {
		return coordinator.canICapture(toColumn, toRow);
	}

	public String whoWon() {
		return coordinator.whoWon();
	}

	public void undoMove() {
		coordinator.undoMove();
	}

}
