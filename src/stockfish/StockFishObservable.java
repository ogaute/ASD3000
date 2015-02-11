package stockfish;

import java.util.Observable;
import java.util.Observer;

public class StockFishObservable extends Observable implements Observer{

	String FEN = "";
	String bestMove = "";
	float score = 0;
	StockfishClient sc;
	
	public StockFishObservable() {
		sc = new StockfishClient();
		
		if (sc.startEngine()) {
			System.out.println("Engine has started..");
		} else {
			System.out.println("Oops! Something went wrong..");
		}
		
		// send commands manually
		sc.sendCommand("uci");
		
		// receive output dump
		System.out.println(sc.getOutput(0));
	}
	
	public void setValue(){
		setChanged();
		bestMove = sc.getBestMove(FEN, 100);
		score = sc.getEvalScore(FEN, 1000);
		notifyObservers("Best move: " + bestMove + "\nScore: " + score);
		clearChanged();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		FEN = (String)arg1;
		setValue();
	}

}
