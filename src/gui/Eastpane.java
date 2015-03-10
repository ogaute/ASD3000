package gui;

import java.awt.*;
import javax.swing.*;
import controller.Controller;

/**
 *  Klassen Eastpane har ansvar for å lage brukergrensesnittelementer,
 *  Sette tilstand på knapper og  Fylle tekst i tekstområdet.
 */
public class Eastpane extends JPanel{

	
	private JButton undo;
	private JButton redo;
    private JTextArea legalMoveTextArea;

    private String infoText = "";

    /**
     * Konstruktøren for denne klassen , Instansierer flere objekter
     */
	public Eastpane() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 800));
        undo = new JButton("Undo");
        undo.addActionListener(Controller.actionundo);
        redo = new JButton("Redo");
        redo.addActionListener(Controller.actionredo);

        legalMoveTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(legalMoveTextArea);

        legalMoveTextArea.setSize(200, 200);
        legalMoveTextArea.setLineWrap(true);
        legalMoveTextArea.setMargin(new Insets(5, 5, 5, 5));
        legalMoveTextArea.setVisible(true);
        legalMoveTextArea.setEditable(false);
        legalMoveTextArea.setText(infoText);

        JPanel northpanel = new JPanel();
        JPanel centerpanel = new JPanel(new BorderLayout());
        JPanel southpanel = new JPanel();
        southpanel.add(undo);
        southpanel.add(redo);
        northpanel.add(new JLabel("Lovlige trekk fra StockFish"));

        centerpanel.add(jScrollPane);
        add(northpanel, BorderLayout.NORTH);
        add(centerpanel, BorderLayout.CENTER);
        add(southpanel, BorderLayout.SOUTH);


	}

    /**
     * Setter tilstanden til Undo enten til true til false
     * @param enable boolean verdi for on undo knappen skal være aktivisert eller ikke
     */
	public void setUndoEnable(boolean enable){
		undo.setEnabled(enable);
	}

    /**
     * Setter tilstanden til Redo enten til false eller true.
     * @param enable boolean verdi for on redo knappen skal være aktivisert eller ikke
     */
	public void setRedoEnable(boolean enable){
		redo.setEnabled(enable);
	}

    /**
     * Setter tekst til tekstpanelet
     * @param legalMoves En tekstren som inneholder alle lovlige trekk til den aktive spilleren
     */
    public void addLegalMovesInfo(String legalMoves) {
        legalMoveTextArea.setText(legalMoves + "\n");
    }


}