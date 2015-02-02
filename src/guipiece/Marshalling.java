package guipiece;


public interface Marshalling {
	
	String WHITE  = "hvit";
	String BLACK = "svart";
	
	Piece[][] MARSHALLING = {
			{new Rook(true, BLACK), new Knight(true, BLACK), new Bishop(true, BLACK), new Queen(true, BLACK), new King(true, BLACK), new Bishop(true, BLACK), new Knight(true, BLACK), new Rook(true, BLACK)},
			{new Pawn(true, BLACK), new Pawn(true, BLACK),    new Pawn(true, BLACK), new Pawn(true, BLACK),    new Pawn(true, BLACK), new Pawn(true, BLACK), new Pawn(true, BLACK),    new Pawn(true, BLACK)},
			
			{null,null, null, null, null, null, null, null}, 
			{null,null, null, null, null, null, null, null}, 
			{null,null, null, null, null, null, null, null}, 
			{null,null, null, null, null, null, null, null}, 
			
			{new Pawn(false, WHITE), new Pawn(false, WHITE),    new Pawn(false, WHITE), new Pawn(false, WHITE),    new Pawn(false, WHITE), new Pawn(false, WHITE), new Pawn(false, WHITE),    new Pawn(false, WHITE)}, 
			{new Rook(false, WHITE), new Knight(false, WHITE), new Bishop(false, WHITE), new Queen(false, WHITE), new King(false, WHITE), new Bishop(false, WHITE), new Knight(false, WHITE), new Rook(false, WHITE)}
	};
	
	
}
