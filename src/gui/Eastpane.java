package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.undo.UndoableEdit;

import controller.Controller;

public class Eastpane extends JPanel{

	
	private JButton undo;
	private JButton redo;
    private JTextArea infobox;
    private String infoText;

	
	public Eastpane() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 800));

        undo = new JButton("Undo");
        undo.addActionListener(Controller.actionundo);
        redo = new JButton("Redo");
        redo.addActionListener(Controller.actionredo);
        infobox = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(infobox);
        infobox.setSize(180,200);
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
	
	public void setUndoEnable(boolean enable){
		undo.setEnabled(enable);
	}
	
	public void setRedoEnable(boolean enable){
		redo.setEnabled(enable);
	}


    public void addFenInfo(String fen) {
        infobox.append(fen + "\n");
    }
}