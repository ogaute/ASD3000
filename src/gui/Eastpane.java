package gui;

import java.awt.*;
import javax.swing.*;
import controller.Controller;

public class Eastpane extends JPanel{

	
	private JButton undo;
	private JButton redo;
    private JTextArea infobox;
    private String infoText = "";

    /**
     *
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
     *
     * @param enable
     */
	public void setUndoEnable(boolean enable){
		undo.setEnabled(enable);
	}

    /**
     *
     * @param enable
     */
	public void setRedoEnable(boolean enable){
		redo.setEnabled(enable);
	}

    /**
     *
     * @param legalMoves
     */
    public void addLegalMovesInfo(String legalMoves) {
        infobox.setText(legalMoves + "\n");
    }


}