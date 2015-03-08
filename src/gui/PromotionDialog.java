package gui;

import javax.swing.*;

/**
 * Denne klassen er ansvar for å håndtere brukerdialog slik at man kan håndtere en forfremmelse
 */
public class PromotionDialog {
    /**
     * Konstruktørene til dialogvinduet
     * @param promotionFrame
     * @return returnerer det valget man har gjort i dialogvinduet
     */
    public String makePromotionWindow(JFrame promotionFrame) {
        String promotionChoice = "";
        Object[] options = {"Queen", "Rook" ,"Knight","Bishop"};
        int n = JOptionPane.showOptionDialog(promotionFrame,
                "Du kan forfremme bonden din !!",
                "Forfremmelse",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (n == 0) {
            promotionChoice = "Queen";
        } else if (n == 1) {
            promotionChoice = "Rook";
        }
        else if (n == 2) {
            promotionChoice = "Knight";
        }
        else if (n == 3) {
            promotionChoice = "Bishop";
            ;
        }
        return promotionChoice;
    }
}
