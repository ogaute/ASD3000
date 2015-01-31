package stockfish;

import java.util.ArrayList;

public class DummyDataCreator {

	private ArrayList<ArrayList<String>> boardPositions = new ArrayList<ArrayList<String>>(); 
	
	
	public DummyDataCreator(){
		
		ArrayList<String> row8 = new ArrayList<String>(); 
		row8.add("r");
		row8.add("n");
		row8.add("b");
		row8.add("q");
		row8.add("k");
		row8.add("b");
		row8.add("n");
		row8.add("r");
		boardPositions.add(row8);
		
		ArrayList<String> row7 = new ArrayList<String>();
		row7.add("p");
		row7.add("p");
		row7.add("p");
		row7.add("p");
		row7.add("p");
		row7.add("p");
		row7.add("p");
		row7.add("p");
		boardPositions.add(row7);
		
		ArrayList<String> row6 = new ArrayList<String>();
		row6.add("1");
		row6.add("1");
		row6.add("1");
		row6.add("1");
		row6.add("1");
		row6.add("1");
		row6.add("1");
		row6.add("1");
		boardPositions.add(row6);
		
		ArrayList<String> row5 = new ArrayList<String>();
		row5.add("1");
		row5.add("1");
		row5.add("1");
		row5.add("1");
		row5.add("1");
		row5.add("1");
		row5.add("1");
		row5.add("1");
		boardPositions.add(row5);
		
		ArrayList<String> row4 = new ArrayList<String>();
		row4.add("1");
		row4.add("1");
		row4.add("1");
		row4.add("1");
		row4.add("1");
		row4.add("1");
		row4.add("1");
		row4.add("1");
		boardPositions.add(row4);
		
		ArrayList<String> row3 = new ArrayList<String>();
		row3.add("1");
		row3.add("1");
		row3.add("1");
		row3.add("1");
		row3.add("1");
		row3.add("1");
		row3.add("1");
		row3.add("1");
		boardPositions.add(row3);
		
		ArrayList<String> row2 = new ArrayList<String>();
		row2.add("P");
		row2.add("P");
		row2.add("P");
		row2.add("P");
		row2.add("P");
		row2.add("P");
		row2.add("P");
		row2.add("P");
		boardPositions.add(row2);
		
		ArrayList<String> row1 = new ArrayList<String>();
		row1.add("R");
		row1.add("N");
		row1.add("B");
		row1.add("Q");
		row1.add("K");
		row1.add("B");
		row1.add("N");
		row1.add("R");
		boardPositions.add(row1);
	}

	public ArrayList<ArrayList<String>> getPositions() {
		return boardPositions;
	}

}