package logic.pieceLogic;

public interface PieceMessage {

	String getFENSymbol();
	void pressed(int column, int row);
}
