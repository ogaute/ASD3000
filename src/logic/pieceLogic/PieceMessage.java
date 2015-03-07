package logic.pieceLogic;

public interface PieceMessage {
    /**
     *
     * @return
     */
	String getFENSymbol();
	void pressed(int column, int row);
}
