package logic;

import controller.Controller;
import gui.ApplicationConstants;
import gui.pieceGui.Bishop;
import gui.pieceGui.Knight;
import gui.pieceGui.Piece;
import gui.pieceGui.Queen;
import gui.pieceGui.Rook;

/**
 * Klasse som har ansvar for å håndtere promoting, eller bondeforvandling
 */
public class Promoter {

    /**
     * Metode som sjekker om promoting er lovlig. Rad skal være korrekt og brikken skal ha symbol for Pawn
     * @param row hvilken rad det skal flyttes til
     * @param fenSymbol symbolet til piece som skal valideres
     * @return om promotion er lovlig eller ikke
     */
	public boolean isItTimeForPromotion(int row, String fenSymbol){
		boolean isPromotion = false;
		if( (row == 0 || row == 7) && fenSymbol.equalsIgnoreCase(ApplicationConstants.SYMBOL_BLACK_PAWN)){
			isPromotion = true;
		}
		return isPromotion;
	}

    /**
     * Metode som promoterer brikke fra pawn til ønsket offiser (med unntak av King).
     * Sjekker farge på brikke, sender melding i CoR om å vise promoteringsvindu.
     * Basert på brukervalg instansieres en ny officerbrikke
     * @param fenSymbol symbolet til piece som skal promoteres
     * @return promotert piece.
     */
	public Piece getPromoted(String fenSymbol){
		Piece promotedPiece = null;
		boolean isBlack = false;
		
		if(fenSymbol.equals(ApplicationConstants.SYMBOL_BLACK_PAWN))
			isBlack = true;
		
		String promotionType = Controller.promotionDialog();
        if(promotionType.equalsIgnoreCase("Queen"))
        {
            promotedPiece = new Queen(isBlack);
        }
         if(promotionType.equalsIgnoreCase("Bishop"))
        {
        	 promotedPiece = new Bishop(isBlack);
        }
        if(promotionType.equalsIgnoreCase("Rook"))
        {
        	promotedPiece = new Rook(isBlack);
        }
        if(promotionType.equalsIgnoreCase("Knight"))
        {
        	promotedPiece = new Knight(isBlack);
        }
		
		return promotedPiece;
	}

	
}
