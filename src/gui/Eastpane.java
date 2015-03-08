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
    private JTextArea infobox;
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

        infobox = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(infobox);

        infobox.setSize(200,200);
        infobox.setLineWrap(true);
        infobox.setMargin(new Insets(5,5,5,5));
        infobox.setVisible(true);
        infobox.setEditable(false);
        infobox.setText(infoText);

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
        infobox.setText(legalMoves + "\n");
    }


}