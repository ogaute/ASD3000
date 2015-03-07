package stockfish;

import java.util.Observable;
import java.util.Observer;

public class StockFishHandler extends Observable implements Observer{


	private String FEN = "";
    private String[] stockFishInfo = new String[3];
    private StockfishClient stockfishClient;
	
	public StockFishHandler() {
		stockfishClient = new StockfishClient();
		if (stockfishClient.startEngine()) {
			System.out.println("Stockfish har startet..");
		} else {
			System.out.println("Oops! Noe gikk galt ..");
		}
		// sender kommando manuelt inn
		stockfishClient.sendCommand("uci");
	}
	
	public void setValue(){
		setChanged();
		//stockFishInfo[0] = stockfishClient.getBestMove(FEN, 200);
		//stockFishInfo[1] = "" + stockfishClient.getEvalScore(FEN, 1000);
		stockFishInfo[2] = stockfishClient.getLegalMoves(FEN);
		notifyObservers(stockFishInfo);
		clearChanged();
	}
	
	@Override
	public void update(Observable observable, Object fen) {
		FEN = (String)fen;
		setValue();
	}


}
