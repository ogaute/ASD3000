package logicpiece;

import gui.Square;

import java.util.ArrayList;

/**
 * Created by Anders Borg Larsen on 10.02.2015.
 */
public class QueenLogic extends PieceLogic {


    public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c){
        boolean playerColor = c;
        possibleMove.clear();


        int tempx=x-1;
        while(tempx>=0)
        {
            if(state[tempx][y].getPiece()==null)
                possibleMove.add(state[tempx][y]);
            else if(state[tempx][y].getPiece().getPlayerColor()==playerColor)
                break;
            else
            {
                possibleMove.add(state[tempx][y]);
                break;
            }
            tempx--;
        }

        tempx=x+1;
        while(tempx<8)
        {
            if(state[tempx][y].getPiece()==null)
                possibleMove.add(state[tempx][y]);
            else if(state[tempx][y].getPiece().getPlayerColor()==playerColor)
                break;
            else
            {
                possibleMove.add(state[tempx][y]);
                break;
            }
            tempx++;
        }


        //Checking possible moves in horizontal Direction
        int tempy=y-1;
        while(tempy>=0)
        {
            if(state[x][tempy].getPiece()==null)
                possibleMove.add(state[x][tempy]);
            else if(state[x][tempy].getPiece().getPlayerColor()==playerColor)
                break;
            else
            {
                possibleMove.add(state[x][tempy]);
                break;
            }
            tempy--;
        }
        tempy=y+1;
        while(tempy<8)
        {
            if(state[x][tempy].getPiece()==null)
                possibleMove.add(state[x][tempy]);
            else if(state[x][tempy].getPiece().getPlayerColor()==playerColor)
                break;
            else
            {
                possibleMove.add(state[x][tempy]);
                break;
            }
            tempy++;
        }

        //Checking for possible moves in diagonal direction
        tempx=x+1;tempy=y-1;
        while(tempx<8&&tempy>=0)
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
        return possibleMove;
    }
}