package logicpiece;

import gui.Square;

import java.util.ArrayList;

/**
 * Created by Anders Borg Larsen on 10.02.2015.
 */
public class BishopLogic extends PieceLogic {

    public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c, ArrayList<Square> legaMovesWhenKingInCheck){
		ArrayList<Square> possibleMove = new ArrayList<Square>();
        boolean playerColor = c;
        possibleMove.clear();

        int tempx=x+1,tempy=y-1;
        while(tempx<8&&tempy>=0)
        {
            if(state[tempx][tempy].getPiece()==null)
            {
                possibleMove.add(state[tempx][tempy]);
            }
            else if(state[tempx][tempy].getPiece().getPlayerColor()==playerColor)
                break;
            else
            {
                possibleMove.add(state[tempx][tempy]);
                break;
            }
            tempx++;
            tempy--;
        }
        tempx=x-1;tempy=y+1;
        while(tempx>=0&&tempy<8)
        {
            if(state[tempx][tempy].getPiece()==null)
                possibleMove.add(state[tempx][tempy]);
            else if(state[tempx][tempy].getPiece().getPlayerColor()==playerColor)
                break;
            else
            {
                possibleMove.add(state[tempx][tempy]);
                break;
            }
            tempx--;
            tempy++;
        }
        tempx=x-1;tempy=y-1;
        while(tempx>=0&&tempy>=0)
        {
            if(state[tempx][tempy].getPiece()==null)
                possibleMove.add(state[tempx][tempy]);
            else if(state[tempx][tempy].getPiece().getPlayerColor()==playerColor)
                break;
            else
            {
                possibleMove.add(state[tempx][tempy]);
                break;
            }
            tempx--;
            tempy--;
        }
        tempx=x+1;tempy=y+1;
        while(tempx<8&&tempy<8)
        {
            if(state[tempx][tempy].getPiece()==null)
                possibleMove.add(state[tempx][tempy]);
            else if(state[tempx][tempy].getPiece().getPlayerColor()== playerColor)
                break;
            else
            {
                possibleMove.add(state[tempx][tempy]);
                break;
            }
            tempx++;
            tempy++;
        }
        
        kingInCheckFilter(legaMovesWhenKingInCheck, possibleMove);
        
        return possibleMove;
    }
}