package stockfish;

import java.util.Observable;
import java.util.Observer;

public class stockFishObservable extends Observable implements Observer{


	private String FEN = "";
    private String[] stockFishInfo = new String[3];
    private StockfishClient stockfishClient;

    /**
     * the method stockFishHandler is responsibel for handling and starting the
     * StockFishClient. When started it sends a command to the StockFishClient.
     */
	public stockFishObservable() {
		stockfishClient = new StockfishClient();
		if (stockfishClient.startEngine()) {
			System.out.println("Stockfish har startet..");
		} else {
			System.out.println("Oops! Noe gikk galt ..");
		}
		// sender kommando manuelt inn
		stockfishClient.sendCommand("uci");
	}

    /**
     *
     */
	public void setValue(){
		setChanged();
		//stockFishInfo[0] = stockfishClient.getBestMove(FEN, 200);
		//stockFishInfo[1] = "" + stockfishClient.getEvalScore(FEN, 1000);
		stockFishInfo[2] = stockfishClient.getLegalMoves(FEN);
		notifyObservers(stockFishInfo);
		clearChanged();
	}

    /**
     * The update method the is esensial to the Observer
     * @param observable
     * @param fen
     */
	@Override
	public void update(Observable observable, Object fen) {
		FEN = (String)fen;
		setValue();
	}


}
