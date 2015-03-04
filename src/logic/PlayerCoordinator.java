package logic;

import gui.Marshalling;

public class PlayerCoordinator {
	
	private String playerInTurn = Marshalling.WHITE;
	
	public String whoIsInTurn(){
		return playerInTurn;
	}
	
	public String whoWon(){
		return (playerInTurn == Marshalling.WHITE) ? Marshalling.BLACK : Marshalling.WHITE;
	}
	
	public void changePlayerInTurn(){
		playerInTurn = (playerInTurn == Marshalling.WHITE) ? Marshalling.BLACK : Marshalling.WHITE;
	}

}
