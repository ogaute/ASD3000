package logic.pieceLogic;

/**
 * Standarisering av metodene for brikker logikk klasser. <p>
 */
public interface PieceMessage {
    /**
     * Ment å retunere symbolet til brikken
     * @return symbolet til brikken
     */
	String getFENSymbol();
    /**
     * Melding som sendes når kvadratet som brikken står på blir presset
     */
	void pressed(int column, int row);
}
