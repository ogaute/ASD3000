package gui;


import logic.GameCoordinator;

import javax.swing.*;
import java.awt.*;

public class Centerpane extends JPanel {
	
	private GameCoordinator coordinator;
   private final String[] LETTERS = { "A", "B", "C", "D", "E", "F", "G", "H" };

    JPanel southCoordinates;
	JPanel eastCoordinates;
	JPanel northCoordinates;
	JPanel westCoordinates;

    /**
     *
     */
	public Centerpane() {
		setLayout(new BorderLayout());
		ChessBoard board;
		add(board = new ChessBoard());
		makeCoordinates();
		coordinator = new GameCoordinator(board);
    }

    /**
     *
     */
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

		for (int j = 0; j <= 9; j++) {
			if (j != 9 && j != 0) {
				southCoordinates.add(new JLabel(LETTERS[j - 1],
						SwingConstants.CENTER));
				northCoordinates.add(new JLabel(LETTERS[j - 1],
						SwingConstants.CENTER));
				eastCoordinates.add(new JLabel("  " + (9 - j) + "  ",
						SwingConstants.CENTER));
				westCoordinates.add(new JLabel("  " + (9 - j) + "  ",
						SwingConstants.CENTER));
			}
		}
	}



    /** CoR meldingsstier
     *
     * @param column
     * @param row
     * @return
     */
    public boolean canIMoveTo(int column, int row) {
		return coordinator.canIMoveTo(column, row);
	}

    /** CoR meldingsstier
     *
     */
	public void resetSquares() {
		coordinator.resetSquares();
	}

    /** CoR meldingsstier
     *
     * @param column
     * @param row
     */
	public void moveTo(int column, int row) {
		coordinator.moveTo(column, row);
	}

    /** CoR meldingsstier
     *
     * @param column
     * @param row
     */
	public void setLastPressed(int column, int row) {
		coordinator.setLastPressed(column, row);
	}

    /** CoR meldingsstier
     *
     */
	public void changePlayerInTurn() {
		coordinator.changePlayerInTurn();
	}

    /** CoR meldingsstier
     *
     * @return
     */
	public String getPlayerInTurn() {
		return coordinator.whoIsInTurn();
	}

    /** CoR meldingsstier
     *
     * @param toColumn
     * @param toRow
     * @return
     */
	public boolean canICapture(int toColumn, int toRow) {
		return coordinator.canICapture(toColumn, toRow);
	}

    /** CoR meldingsstier
     *
     * @return
     */
	public String whoWon() {
		return coordinator.whoWon();
	}

    /** CoR meldingsstier
     *
     */
	public void undoMove() {
		coordinator.undoMove();
	}

    /** CoR meldingsstier
     *
     */
	public void redoMove() {
		coordinator.redoMove();
	}

}
