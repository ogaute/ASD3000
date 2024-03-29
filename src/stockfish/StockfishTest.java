package stockfish;

import gui.ApplicationFrame;

public class StockfishTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		StockfishClient client = new StockfishClient();
		//"2r1nr1k/pp1q1p1p/3bpp2/5P2/1P1Q4/P3P3/1B3P1P/R3K1R1"
		String FEN = "8/6pk/8/1R5p/3K3P/8/6r1/8 b - - 0 42"; 
		
		// initialize and connect to engine
		if (client.startEngine()) {
			System.out.println("Engine has started..");
		} else {
			System.out.println("Oops! Something went wrong..");
		}
		
		// send commands manually
		client.sendCommand("uci");
		
		// receive output dump
		System.out.println(client.getOutput(0));
		
		// get the best move for a position with a given think time
		System.out.println("Best move : " + client.getBestMove(FEN, 100));
		
		// get all the legal moves from a given position
		System.out.println("Legal moves : " + client.getLegalMoves(FEN));
		
		// draw board from a given position
		System.out.println("Board state :");
		client.drawBoard(FEN);
		
		// get the evaluation score of current position
		System.out.println("Evaluation score : " + client.getEvalScore(FEN, 2000));
		
		// stop the engine
		System.out.println("Stopping engine..");
		client.stopEngine();
	
	}

}
