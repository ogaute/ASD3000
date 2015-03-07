package logic;

import gui.ApplicationConstants;

public class PlayerCoordinator {
	
	private String playerInTurn = ApplicationConstants.WHITE;

    /**
     * @return
     */
	public String whoIsInTurn(){
		return playerInTurn;
	}

    /**
     *
     * @return
     */
	public String whoWon(){
		return (playerInTurn.equals(ApplicationConstants.WHITE)) ? ApplicationConstants.BLACK : ApplicationConstants.WHITE;
	}

    /**
     *
     */
	public void changePlayerInTurn(){
		playerInTurn = (playerInTurn.equals(ApplicationConstants.WHITE)) ? ApplicationConstants.BLACK : ApplicationConstants.WHITE;
	}

}
