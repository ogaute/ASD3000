package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.undo.UndoableEdit;

import controller.Controller;

public class Eastpane extends JPanel{

	
	private JButton undo;
	private JButton redo;
	
	public Eastpane() {
		// info.setSize(200, 800);
		setPreferredSize(new Dimension(200, 800));
		undo = new JButton("Undo");
		undo.addActionListener(Controller.actionundo);
		redo = new JButton("Redo");
		add(undo);
		add(redo);
	}
	
	public void setUndoEnable(boolean enable){
		undo.setEnabled(enable);
	}
	
	public void setRedoEnable(boolean enable){
		redo.setEnabled(enable);
	}


}