package logic.pieceLogic;

public class RookLogic {
	
	private String pieceColor;
	private String pieceSymbol;
	
	public RookLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getPieceSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "r";
		}
		else {
			pieceSymbol = "R";
		}
	}
	
}
