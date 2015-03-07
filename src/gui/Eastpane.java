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
        infobox.setVisible(true);
        infobox.setEditable(false);
        infobox.setText(infoText);

        JPanel northpanel = new JPanel();
        JPanel southpanel = new JPanel(new BorderLayout());
        northpanel.add(undo);
        northpanel.add(redo);


        southpanel.add(jScrollPane);
        add(northpanel, BorderLayout.NORTH);
        add(southpanel,BorderLayout.CENTER);




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
     * @param fen
     */
    public void addFenInfo(String fen) {
        infobox.append(fen + "\n");
    }


}