package saveLogic;
import java.util.ArrayList;
import java.util.List;


/*
Ansvarlig for å gjennoprette tilstand fra BoardState
(Caretaker)
 */
public class BoardStateHandler {

    /**
     *
     */
   private List<BoardState> boardStateList = new ArrayList<BoardState>();

    /**
     *
     * @param boardState
     */
   public void add(BoardState boardState){
      boardStateList.add(boardState);
   }

    /**
     *
     * @param index
     * @return
     */
   public BoardState get(int index){
      return boardStateList.get(index);
   }
   
//    ikke i bruk .
// public BoardState remove(int index){
//	  return boardStateList.remove(index);
//   }

    /**
     *
     * @return
     */
   public int length(){
	   return boardStateList.size();
   }
   
   
}