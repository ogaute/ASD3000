package stockfish;

import java.util.ArrayList;


public class FENgenerator {
			
	private ArrayList<ArrayList<String>> boardPositions;
	private String sideToMove = "w";  		//  {'w' | 'b'}
	private String castlingAbility = ""; 	// 
	private String enPassant = ""; 			// 
	private String halfmoveClock = "";		
	private String fullMoveCounter ="";		// 

	public FENgenerator(){
		// lager litt dummydata - Arraylist av arraylist av Strings
		DummyDataCreator ddc = new DummyDataCreator();
		boardPositions = ddc.getPositions();
	}

	public String generateFEN() {

		// generator		
		StringBuilder sb = new StringBuilder();
		int sumNumbers = 0;
		
		for(ArrayList<String> positions : boardPositions){
			
			for(String position : positions){		
				char ch = position.charAt(0);
				if(Character.isDigit(ch)){
					sumNumbers += Character.getNumericValue(ch);				
				} else {
					if(sumNumbers !=0){
						sb.append(Integer.toString(sumNumbers));
					}
					sumNumbers = 0;
					sb.append(ch);	
				}		
			}
			if(sumNumbers !=0){
				sb.append(Integer.toString(sumNumbers));
				sumNumbers = 0;
			}
			sb.append("/");		
		}		
		sb.append(" " + sideToMove);
		sb.append(" " + castlingAbility);
		sb.append(" " + enPassant);
		sb.append(" " + halfmoveClock);
		sb.append(" " + fullMoveCounter);
		System.out.println(sb.toString());
		

		return sb.toString();
	}

	
}