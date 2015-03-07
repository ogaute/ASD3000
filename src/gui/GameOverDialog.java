package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;

public class GameOverDialog {

    /**
     *
     * @param frame
     */
	public GameOverDialog(JFrame frame) {
		String player = Controller.whoWon();
		Object[] options = {"Nytt spill", "Avslutt"};
		int n = JOptionPane.showOptionDialog(frame,
		"Spiller " +  player + " har vunnet!",
		"Sjakkmatt",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[1]);
		
		if(n == JOptionPane.YES_OPTION){
			Chessie.restart();
		}
		else{
			Controller.exit();
		}
	}
	

}
