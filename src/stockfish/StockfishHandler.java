package stockfish;

import java.util.Observable;
import java.util.Observer;

/**
 * Klassen StockfishHandler har som ansvar å aggreggere og kommunisere med
 * StockfishClient. Gi beskjed til sine observere når tilstand endrer seg 
 * og oppdatere sin tilstand når objekter den observerer har endret tilstand.
 */

public class StockfishHandler extends Observable implements Observer{


	private String FEN = "";
    private String[] stockFishInfo = new String[3];
    private StockfishClient stockfishClient;

    /**
     * Konstruktør. Instansierer StockfishClient, og ber den starte motoren, og sende
     * kommando dersom det gikk bra. 
     */
	public StockfishHandler() {
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
     *Metoden fyller et String-array basert på hva som returneres av StockfishClient.<p>
     *Mulige observerere blir gitt beskjed om at endring har skjedd
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
     * Metoden utføres når objektet man observerer har endret tilstand.<p>
     * Klassefelt oppdateres med mottat fen-streng, og metoden setValue kjøres.
     * @param observable Objektet man observerer
     * @param fen String som er bygd opp i henhold til regler for FEN
     * @see Observable 
     */
	@Override
	public void update(Observable observable, Object fen) {
		FEN = (String)fen;
		setValue();
	}


}
