package logic;

import controller.Controller;
import gui.ApplicationConstants;
import gui.pieceGui.Bishop;
import gui.pieceGui.Knight;
import gui.pieceGui.Piece;
import gui.pieceGui.Queen;
import gui.pieceGui.Rook;

public class Promoter {
	
	
	public boolean isItTimeForPromotion(int row, String fenSymbol){
		boolean isPromotion = false;
		if( (row == 0 || row == 7) && fenSymbol.equalsIgnoreCase(ApplicationConstants.SYMBOL_BLACK_PAWN)){
			isPromotion = true;
		}
		return isPromotion;
	}
	
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
