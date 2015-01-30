package guipiece;


public interface Marshalling {
	
	String WHITE  = "hvit";
	String BLACK = "svart";
	
	Piece[] MARSHALLING = {
			
			new Rook(BLACK), new Knight(BLACK), new Bishop(BLACK), new Queen(BLACK), new King(BLACK), new Bishop(BLACK), new Knight(BLACK), new Rook(BLACK),
			new Pawn(BLACK), new Pawn(BLACK),    new Pawn(BLACK), new Pawn(BLACK),    new Pawn(BLACK), new Pawn(BLACK), new Pawn(BLACK),    new Pawn(BLACK), 
			
			null,null, null, null, null, null, null, null,  
			null,null, null, null, null, null, null, null, 
			null,null, null, null, null, null, null, null, 
			null,null, null, null, null, null, null, null,
			
			new Pawn(WHITE), new Pawn(WHITE),    new Pawn(WHITE), new Pawn(WHITE),    new Pawn(WHITE), new Pawn(WHITE), new Pawn(WHITE),    new Pawn(WHITE), 
			new Rook(WHITE), new Knight(WHITE), new Bishop(WHITE), new Queen(WHITE), new King(WHITE), new Bishop(WHITE), new Knight(WHITE), new Rook(WHITE)
	};
	
	
}
