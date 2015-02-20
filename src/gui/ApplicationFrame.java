package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logic.ChessCoordinator;
import logicpiece.ChessHelper;
import logicpiece.PieceInControll;
import controller.Controller;
import easylib.controller.ISupercontroller;
import guipiece.Piece;

public class ApplicationFrame extends JFrame implements ISupercontroller {

	private Centerpane centerpane = null;
	private Southpane southpane = null;
	private Eastpane eastpane = null;
	
	private ChessCoordinator chessCoordinator = null;
	private ChessHelper chessHelper = null;

	public ApplicationFrame() {
		Controller.init(this);
		setTitle("Chessie");
		setLayout(new BorderLayout());
		chessCoordinator = new ChessCoordinator();
		add(centerpane = new Centerpane(chessCoordinator.getBoard()), BorderLayout.CENTER);
		add(southpane = new Southpane(), BorderLayout.SOUTH);
		add(eastpane = new Eastpane(), BorderLayout.EAST);
		setJMenuBar(new MenuController());
		setLocationRelativeTo(null);
		setSize(1000,800);
		setVisible(true);
		//System.out.println(" La til denne for å teste ");
		setResizable(false);
		
	    /*addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentResized(ComponentEvent e) {
	        //System.out.println("Reseized");
	        //repaint();
	        setSize(getSize().width, getSize().width);
	      }
	    });*/
		
		chessHelper = new ChessHelper();
		
	}

	public void exit() {
		System.exit(0);
	}

	public void about() {
		JOptionPane.showMessageDialog(this, "Chessgame 0.1");
	}

	public void setStatustext(String s) {
		// TODO Auto-generated method stub
		// Dette er Application Som trenger ett l�ft
		// mERE mErEW mmERE
	}

	public ArrayList<Square> canIMove(Piece p, Square[][] state, int x, int y, boolean c) {
		return chessHelper.canIMove(p, state, x, y, c);
	}

	public boolean turn(){
		return chessHelper.turn();
	}

	public void nextTurn() {
		chessHelper.nextTurn();
	}
	
	@Override
	public void repaint() {
		super.repaint();
		//setSize(getSize().width, getSize().width);
	}
	
	public StockFishInfo getSFI(){
		return eastpane.getSFI();
	}

	public void pressed(int indexX, int indexY) {
		chessCoordinator.pressed(indexX, indexY);
	}

	public void addToHistory() {
		chessCoordinator.addToHistory();
	}

	public ArrayList<Square> getKings() {
		return chessCoordinator.getKings();
	}

	public ArrayList<PieceInControll> isInControll(Square[][] tryState, Square destination) {
		return chessHelper.isInControll(tryState,destination);
	}

}
