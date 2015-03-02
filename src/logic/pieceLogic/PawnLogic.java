package logic.pieceLogic;

public class PawnLogic {

	private String pieceColor;
	private String pieceSymbol;
	private int direction;
	
	public PawnLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getPieceSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "p";
			direction = 1;
		}
		else {
			pieceSymbol = "P";
			direction = -1;
		}
	}
	
}
