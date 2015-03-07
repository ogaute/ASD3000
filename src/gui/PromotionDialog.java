package gui;

import javax.swing.*;

/**
 * Created by Anders Borg Larsen on 06.03.2015.
 */
public class PromotionDialog {

    public String makePromotionWindow(JFrame app) {
        String promotionChoice = "";
        Object[] options = {"Queen", "Rook" ,"Knight","Bishop"};
        int n = JOptionPane.showOptionDialog(app,
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
