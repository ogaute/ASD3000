package stockfish;

import controller.Controller;
import gui.ApplicationConstants;
import gui.Square;

import java.util.Observable;
import java.util.Observer;


public class FENgenerator extends Observable {

	
	private stockFishObservable stockFishObservable; //observer
	private Square[][] boardPositions;
	private String castlingAbility = "";
	private String enPassant = "";
	private String halfmoveClock = "";		
	private String fullMoveCounter ="";
	private boolean firstMove = true;

    /**
     *
     * @param observer
     */
	public FENgenerator(Observer observer) {
		stockFishObservable = new stockFishObservable(); //observer
        addObserver(stockFishObservable); //observer
        stockFishObservable.addObserver(observer); //observer
	}

    /**
     *
     * @param b
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
     *
     * @param fen
     */
	public void setValue(String fen){
		setChanged();
		notifyObservers(fen);
		clearChanged();

	}


}