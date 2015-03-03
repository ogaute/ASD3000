package stockfish;

import java.util.Observable;
import java.util.Observer;

public class StockFishObservable extends Observable implements Observer{

	String FEN = "";
	String[] stockFishInfo = new String[3];
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
		//stockFishInfo[0] = sc.getBestMove(FEN, 200);
		//stockFishInfo[1] = "" + sc.getEvalScore(FEN, 1000);
		stockFishInfo[2] = sc.getLegalMoves(FEN);
		notifyObservers(stockFishInfo);
		clearChanged();
	}
	
	@Override
	public void update(Observable observable, Object fen) {
		FEN = (String)fen;
		setValue();
	}

}
