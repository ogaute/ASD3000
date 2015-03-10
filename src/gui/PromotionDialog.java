package gui;

import javax.swing.*;

/**
 * Denne klassen er ansvar for å håndtere brukerdialog slik at man kan håndtere en forfremmelse
 */
public class PromotionDialog {
    /**
     * Konstruktørene til dialogvinduet
     * @return returnerer det valget man har gjort i dialogvinduet
     */
    public String makePromotionWindow( ) {

        String promotionChoice = "";
        Object [] options1 = {"Queen", "Rook" ,"Knight","Bishop"};
        JOptionPane promotionDialog = new JOptionPane("Du kan forfremme bonden din !!", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION, null, options1, options1[0]);
        JDialog dialog = promotionDialog.createDialog(null, "Forfremmelse");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);
        String chosenType = (String) promotionDialog.getValue();
        if (chosenType.equals("Queen")) {
            promotionChoice = "Queen";
        } else if (chosenType.equals("Rook")) {
            promotionChoice = "Rook";
        } else if (chosenType.equals("Knight")){
            promotionChoice = "Knight";
        }else if (chosenType.equals("Bishop")){
            promotionChoice = "Bishop";
        }

        return promotionChoice;


    }

}

