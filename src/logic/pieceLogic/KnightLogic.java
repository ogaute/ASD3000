package logic.pieceLogic;

public class KnightLogic {

	private String pieceColor;
	private String pieceSymbol;
	
	public KnightLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getPieceSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "n";
		}
		else {
			pieceSymbol = "N";
		}
	}
}
