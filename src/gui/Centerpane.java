package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Centerpane extends JPanel {

	JPanel boardPanel;
	JPanel southCoordinates;
	JPanel eastCoordinates;
	JPanel northCoordinates;
	JPanel westCoordinates;

	public Centerpane(ChessBoard chessBoard) {
		setLayout(new BorderLayout());
		
		add(chessBoard);

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

		makeCoordinates();

	}

	public void makeCoordinates() {
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

}
