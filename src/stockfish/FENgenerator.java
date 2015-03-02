package stockfish;

import gui.Square;

import java.util.Observable;
import controller.Controller;


public class FENgenerator extends Observable {
			
	private Square[][] boardPositions;
	private String sideToMove = "w";  		//  {'w' | 'b'}
	private String castlingAbility = ""; 	// 
	private String enPassant = ""; 			// 
	private String halfmoveClock = "";		
	private String fullMoveCounter ="";		// 

	public FENgenerator(){
		// lager litt dummydata - Arraylist av arraylist av Strings
		//DummyDataCreator ddc = new DummyDataCreator();
		//boardPositions = ddc.getPositions();
	}

	public String generateFEN(Square[][] b) {

		// generator	
		this.boardPositions = b;
		StringBuilder sb = new StringBuilder();
		int sumNumbers = 0;
		
		for(int y = 0; y <= 7; y++){
			
			for(int x = 0; x <= 7; x++){	
				char ch;
				if(!boardPositions[x][y].HasChild()){
					sumNumbers += 1;				
				} else {
					if(sumNumbers !=0){
						sb.append(Integer.toString(sumNumbers));
					}
					sumNumbers = 0;
					sb.append(boardPositions[x][y].getPiece().getPieceSymbol());	
				}		
			}
			if(sumNumbers !=0){
				sb.append(Integer.toString(sumNumbers));
				sumNumbers = 0;
			}
			sb.append("/");		
		}
		
		if(Controller.turn()){
			sb.append(" " + 'b');
		}
		else{
			sb.append(" " + 'w');
		}
		//sb.append(" " + sideToMove);
		sb.append(" " + castlingAbility);
		sb.append(" " + enPassant);
		sb.append(" " + halfmoveClock);
		sb.append(" " + fullMoveCounter);
		//System.out.println(sb.toString());
		setValue(sb.toString());

		return sb.toString();
	}

	public void setValue(String fen){
		setChanged();
		notifyObservers(fen);
		clearChanged();
	}
	
}