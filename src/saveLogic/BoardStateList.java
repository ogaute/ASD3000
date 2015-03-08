package saveLogic;
import java.util.ArrayList;
import java.util.List;

/**
 * Klassen BoardStateList har ansvar for å holde på en liste over nåværende
 * og historiske brettstillinger. Kan returnere en gitt stilling.
 * 
 * Klassen er med på å skape mønsteret Memento, og fungerer som caretaker.
 */

public class BoardStateList {


   private List<BoardState> boardStateList = new ArrayList<BoardState>();

    /**
     * Legger til en brettstilling i listen
     * 
     * @param boardState Instans av typen BoardState
     */
   public void add(BoardState boardState){
      boardStateList.add(boardState);
   }

    /**
     * Henter en gitt spillebrettsstilling
     * 
     * @param index Et tall som angir hvilken BoardState i listen som skal returneres
     * @return Returnerer en gitt instans av typen BoardState basert på indeks som mottas
     */
   public BoardState get(int index){
      return boardStateList.get(index);
   }

    /**
     * Finner lengden på listen av spillebrettsstillinger
     * 
     * @return Returnerer et tall
     */
   public int length(){
	   return boardStateList.size();
   }
   
   
}