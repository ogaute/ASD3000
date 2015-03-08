package stockfish;

import gui.ApplicationConstants;

public class LegalMoveValidator {

	
	private String legalMovesFromStockfish = "";

    /**
     * Setter innhold i klassefeltvariabel lik mottatt String.<p>
     * Inneholder alle lovlige trekk fra Stockfish i gjeldende brettstilling.
     * 
     * @param legalMovesFromStockfish Streng med alle lovlige trekk
     */
    public void setlegalMovesFromStockfish(String legalMovesFromStockfish){
		this.legalMovesFromStockfish = legalMovesFromStockfish;
	}

    /**
     * Sjekker om brikkens normalt lovlige trekk er lovlig i gjeldende stilling<p>
     * Konverterer rad/kolonne til sjakkkoordinater, og basert på hvilken brikke det er, 
     * så sjekkes det om trekket finnes i strengen som inneholder alle lovlige trekk i stillingen.
     * Lovlige trekk er i sjakknotasjonsformat.Bruker regex for å avgjøre om trekket finnes i strengen med lovlige trekk. 
     * Sjekker bønder og offiserer hver for seg, da bønder ikke kan ta brikker i flytteretning.
     * 
     * @param column Kolonnen det ønskes å sjekke om brikken kan flytte til
     * @param row Raden det ønskes å sjekke om brikken kan flytte til
     * @param FENSymbol Symbolet brikken har i FEN-notasjon.
     * @return Returnerer true dersom trekket er lovlig i gjeldende stilling, ellers false.
     */
	public boolean isLegalForStockfish(int column, int row, String FENSymbol){
		boolean isLegal = false;
		String coordinate = ApplicationConstants.CHESSCOORDINATES[row][column];
		String[] splitedLegalMoves = legalMovesFromStockfish.split(" ");

        for (String splitedLegalMove : splitedLegalMoves) {
            // Validerer lovlige trekk for bonde i spillets stilling
            if (splitedLegalMove.matches("[a-h]*[a-h][1-8][=]*[QRNB]*[+#]*") && FENSymbol.equals("P")) {     
            	if (splitedLegalMove.contains(coordinate)) {
                    isLegal = true;
                    break;
                }
            }
            // Validerer lovlige trekk for offiserer i spillets stilling
            else if (splitedLegalMove.matches("[BKNRQ][x]*[a-h][1-8][+#]*")) {
                if (splitedLegalMove.contains(FENSymbol) && splitedLegalMove.contains(coordinate)) {
                    isLegal = true;
                    break;
                }
            }
        }		
		return isLegal;
	}

    /**
     * Sjekker om en bonde kan slå ut en brikke<p>
     * Konverterer rad/kolonne til sjakkkoordinater, og sjekker det om trekket finnes i strengen 
     * som inneholder alle lovlige trekk i stillingen. Lovlige trekk er i sjakknotasjonsformat.
     * Bruker regex for å avgjøre om trekket finnes i strengen med lovlige trekk.
     * 
     * @param column Kolonnen det ønskes å sjekke om brikken kan flytte til
     * @param row Raden det ønskes å sjekke om brikken kan flytte til
     * @return Returnerer true dersom trekket er lovlig i gjeldende stilling, ellers false.
     */
// Sjekker om Bonde kan slå til siden
	public boolean isPawnCaptureLegalForStockfish(int column, int row){
		boolean isLegal = false;
		String coordinate = ApplicationConstants.CHESSCOORDINATES[row][column];
		String[] splitedLegalMoves = legalMovesFromStockfish.split(" ");

        for (String splitedLegalMove : splitedLegalMoves) {
            // Validerer lovlige trekk for bonde i spillets stilling
            if (splitedLegalMove.matches("^[a-h]{1}[x]{1}[a-h]{1}[1-8][=]*[QRNB]*[+#]*")) {
                if (splitedLegalMove.contains(coordinate)) {
                    isLegal = true;
                    break;
                }
            }
        }
		return isLegal;
	}


}
