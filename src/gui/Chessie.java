package gui;

/**
 *  Denne klassen har ansvar for å starte eller avslutte et nytt spill
 */
public class Chessie {


	private static ApplicationFrame application;

    /**
     * konstruktøren som instansierer en ny ApplicationFrame
     */
	public Chessie() {
		 application = new ApplicationFrame();
	}

    /**
     * metode som har i oppgave og restarte applikasjoen
     */
	public static void restart(){
		application.dispose();
	    application = new ApplicationFrame();
	}
	

}
