package gui;

import javax.swing.*;

import controller.Controller;

/**
 *  Denne klassen har ansvar for å Håndtere brukerdialog
 */
public class GameOverDialog {

    /**
     * Konstruktørene til dialogvinduet som spesifisere utsende til dette vinduet.
     * @param frame er en Jfram som bare blir brukt til dialog vinduet
     */
	public GameOverDialog(JFrame frame) {
		String player = Controller.whoWon();

        Object[] options = {"Nytt spill", "Avslutt"};
        JOptionPane gameOverDialog = new JOptionPane("Spiller \" +  player + \" har vunnet!",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION, null, options, options[0]);
        JDialog dialog = gameOverDialog.createDialog(null, "Sjakkmatt");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);
        String chosenType = (String) gameOverDialog.getValue();

        if(chosenType.equals("Nytt spill")){
			Chessie.restart();
		}
		else{
			Controller.exit();
		}

	}
	

}
