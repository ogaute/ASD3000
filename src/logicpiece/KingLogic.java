package logicpiece;

import gui.Square;

import java.util.ArrayList;

/**
 * Created by Anders Borg Larsen on 10.02.2015.
 */
public class KingLogic extends PieceLogic {


    public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c){
        boolean playerColor = c;
        possibleMove.clear();


        int posx[]={x,x,x+1,x+1,x+1,x-1,x-1,x-1};
        int posy[]={y-1,y+1,y-1,y,y+1,y-1,y,y+1};
        for(int i=0;i<8;i++)
            if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
                if((state[posx[i]][posy[i]].getPiece()==null||state[posx[i]][posy[i]].getPiece().getPlayerColor()!=playerColor))
                    possibleMove.add(state[posx[i]][posy[i]]);
        return possibleMove;
    }


}
