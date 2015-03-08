package stockfish;

import controller.Controller;
import gui.ApplicationConstants;
import gui.Square;

import java.util.Observable;
import java.util.Observer;

/**
 * Klassen FENgenerator har som ansvar å generere en streng på FEN-notasjon.
 * Aggregerer også StockfishHandler og legger en observerer til den.
 * Legger også til StockfishHandler som en observerer til seg.
 * 
 * Klassen implementerer mønsteret Observer
 */

public class FENgenerator extends Observable {

	
	private StockfishHandler stockfishHandler;
	private Square[][] boardPositions;
	private String castlingAbility = "";
	private String enPassant = "";
	private String halfmoveClock = "";		
	private String fullMoveCounter ="";
	private boolean firstMove = true;

	/**
     * Konstruktør. Instansierer StockfishHandler og legger den til som en observerer til seg.
     * Parameteret observer som mottas, legges som en observerer til instansen av StockfishHandler.
     * 
     * @param observer Mottar et objekt som er observerer.
     * @see Observer
     */
	public FENgenerator(Observer observer) {
		stockfishHandler = new StockfishHandler(); 
        addObserver(stockfishHandler); 
        stockfishHandler.addObserver(observer); 
	}

	/**
	* Genererer FEN-streng basert på stillingen på brettet<p>
	* Løper gjennom alle felter på brettet. Dersom feltet har en brikke legges symbolet for brikken til i strengen.
	* Dersom feltet er tomt legges det til 1 på en variabel. Denne variabelen økes helt til det treffes på et felt
	* som har en brikke, og verdien av variabelen legges på strengen. For hver ny rad legges "/" på strengen.
	* Når alle felter er løpt gjennom legges det på symbol for hvilken brikkefarge som har tur.
	* 
	* @param b Felter på sjakkbrettet
	*/
	public void generateFEN(Square[][] b) {
		this.boardPositions = b;
		StringBuilder stringBuilder = new StringBuilder();
		int sumNumbers = 0;
		
		for(int row = 0; row <= ApplicationConstants.NUMROWS; row++){
		    for(int column = 0; column <= ApplicationConstants.NUMCOLUMNS; column++){
                if(!boardPositions[column][row].hasChild()){
					sumNumbers += 1;				
				} else {
					if(sumNumbers !=0){
						stringBuilder.append(Integer.toString(sumNumbers));
					}
					sumNumbers = 0;
					stringBuilder.append(boardPositions[column][row].getPiece().getFENSymbol());
				}		
			}

			if(sumNumbers !=0){
				stringBuilder.append(Integer.toString(sumNumbers));
				sumNumbers = 0;
			}
			stringBuilder.append("/");
		}

        if(firstMove){
			stringBuilder.append(" " + 'w');
			firstMove = false;
		}
		else if(Controller.getPlayerInTurn().equals(ApplicationConstants.WHITE)){
			stringBuilder.append(" " + 'w');
		}
		else{
			stringBuilder.append(" " + 'b');
		}
		//For senere utvidelse av funksjonalitet i spillet
		stringBuilder.append(" " + castlingAbility);
		stringBuilder.append(" " + enPassant);
		stringBuilder.append(" " + halfmoveClock);
		stringBuilder.append(" " + fullMoveCounter);
		setValue(stringBuilder.toString());
	}

    /**
     * Markerer at det har skjedd en endring i tilstand og gir beskjed
     * til sine observerere om at endring har skjedd. Setter så markering
     * om endring tilbake.
     * 
     * @param fen En streng som inneholder FEN-notasjon
     */
	public void setValue(String fen){
		setChanged();
		notifyObservers(fen);
		clearChanged();
	}


}