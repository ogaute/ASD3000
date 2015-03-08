package logic;

import gui.ApplicationConstants;

/**
 * Klasse som er ansvarlig for å håndtere spiller som er i tur
 */
public class PlayerCoordinator {
	
	private String playerInTurn = ApplicationConstants.WHITE;

    /**
     * @return hvilken spiller som er i tur
     */
	public String whoIsInTurn(){
		return playerInTurn;
	}

    /**
     *
     * @return hvilken spiller som vant spillet
     */
	public String whoWon(){
		return (playerInTurn.equals(ApplicationConstants.WHITE)) ? ApplicationConstants.BLACK : ApplicationConstants.WHITE;
	}

    /**
     * Metode som endrer hvilken spiller som er i tur
     */
	public void changePlayerInTurn(){
		playerInTurn = (playerInTurn.equals(ApplicationConstants.WHITE)) ? ApplicationConstants.BLACK : ApplicationConstants.WHITE;
	}

}
