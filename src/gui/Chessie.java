package gui;

public class Chessie {
	
	
	private static ApplicationFrame application;

    /**
     *
     */
	public Chessie() {
		 application = new ApplicationFrame();
	}

    /**
     *
     */
	public static void restart(){
		application.dispose();
	    application = new ApplicationFrame();
	}
	

}
