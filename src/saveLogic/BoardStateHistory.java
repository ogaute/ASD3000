package saveLogic;
import java.util.ArrayList;
import java.util.List;


/*
Ansvarlig for å gjennoprette tilstand fra BoardState
(Caretaker)
 */
public class BoardStateHistory {
	
	
   private List<BoardState> boardStateList = new ArrayList<BoardState>();

   public void add(BoardState boardState){
      boardStateList.add(boardState);
   }

   public BoardState get(int index){
      return boardStateList.get(index);
   }
   
   public BoardState remove(int index){
	  return boardStateList.remove(index);
   }
   
   public int length(){
	   return boardStateList.size();
   }
   
   
}