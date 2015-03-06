package logic.pieceLogic;

import gui.ApplicationConstants;

public class PieceLogicFactory {

	public PieceMessage getPiece(String pieceType, String pieceColor) {
		if (pieceType == null) {
			return null;
		}
		if (pieceType.equalsIgnoreCase("KING")) {
			if (pieceColor.equalsIgnoreCase(ApplicationConstants.BLACK))
				return new KingLogic(ApplicationConstants.BLACK);
			else
				return new KingLogic(ApplicationConstants.WHITE);

		} else if (pieceType.equalsIgnoreCase("QUEEN")) {
			if (pieceColor.equalsIgnoreCase(ApplicationConstants.BLACK))
				return new QueenLogic(ApplicationConstants.BLACK);
			else
				return new QueenLogic(ApplicationConstants.WHITE);

		} else if (pieceType.equalsIgnoreCase("ROOK")) {
			if (pieceColor.equalsIgnoreCase(ApplicationConstants.BLACK))
				return new RookLogic(ApplicationConstants.BLACK);
			else
				return new RookLogic(ApplicationConstants.WHITE);
			
		} else if (pieceType.equalsIgnoreCase("BISHOP")) {
			if (pieceColor.equalsIgnoreCase(ApplicationConstants.BLACK))
				return new BishopLogic(ApplicationConstants.BLACK);
			else
				return new BishopLogic(ApplicationConstants.WHITE);
			
		} else if (pieceType.equalsIgnoreCase("KNIGHT")) {
			if (pieceColor.equalsIgnoreCase(ApplicationConstants.BLACK))
				return new KnightLogic(ApplicationConstants.BLACK);
			else
				return new KnightLogic(ApplicationConstants.WHITE);
			
		} else if (pieceType.equalsIgnoreCase("PAWN")) {
			if (pieceColor.equalsIgnoreCase(ApplicationConstants.BLACK))
				return new PawnLogic(ApplicationConstants.BLACK);
			else
				return new PawnLogic(ApplicationConstants.WHITE);
		}
		

		return null;
	}

}
