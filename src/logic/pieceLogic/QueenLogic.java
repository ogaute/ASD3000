package logic.pieceLogic;

public class QueenLogic {
	
	private String pieceColor;
	private String pieceSymbol;
	
	public QueenLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getPieceSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "q";
		}
		else {
			pieceSymbol = "Q";
		}
	}
}
