package logic.pieceLogic;

public class BishopLogic {
	
	private String pieceColor;
	private String pieceSymbol;
	
	public BishopLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getPieceSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "b";
		}
		else {
			pieceSymbol = "B";
		}
	}

}
