package logic.pieceLogic;

public class KingLogic {

	private String pieceColor;
	private String pieceSymbol;
	
	public KingLogic(String pieceColor) {
		this.pieceColor = pieceColor;
		setPieceProperties();
	}
	
	// dette er nødvendig for å generere FEN streng basert på brettets stilling
	public String getPieceSymbol(){
			return pieceSymbol;
	}
	
	private void setPieceProperties(){
		if(pieceColor == "svart"){
			pieceSymbol = "k";
		}
		else {
			pieceSymbol = "K";
		}
	}
}
