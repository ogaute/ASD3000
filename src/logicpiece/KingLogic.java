package logicpiece;

import gui.Square;
import guipiece.Piece;
import guipiece.Rook;

import java.util.ArrayList;

/**
 * Created by Anders Borg Larsen on 10.02.2015.
 */
public class KingLogic extends PieceLogic {
	
	boolean castelingBlackCanBeDone = true;
	boolean castelingWhiteCanBeDone = true;

    public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c){
        boolean playerColor = c;
        possibleMove.clear();
        boolean casteling = false;

        int posx[]={x,x,x+1,x+1,x+1,x-1,x-1,x-1};
        int posy[]={y-1,y+1,y-1,y,y+1,y-1,y,y+1};
        for(int i=0;i<8;i++)
            if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
                if((state[posx[i]][posy[i]].getPiece()==null||state[posx[i]][posy[i]].getPiece().getPlayerColor()!=playerColor))
                    possibleMove.add(state[posx[i]][posy[i]]);
        
        
        if(!state[x][y].getPiece().isHasMoved()){
        	Piece r = state[0][7].getPiece();
        	if(r != null && r instanceof Rook){
        		if(r.getPlayerColor()==playerColor && !r.isHasMoved()){
        			if(!state[1][7].HasChild() && !state[2][7].HasChild() && !state[3][7].HasChild())
        			{
        				possibleMove.add(state[x - 2][y]);
        				casteling = true;
        			}
        		}
        	}
        	r = state[7][7].getPiece();
        	if(r != null && r instanceof Rook){
        		if(r.getPlayerColor()==playerColor && !r.isHasMoved()){
        			if(!state[5][7].HasChild() && !state[6][7].HasChild())
        			{
        				possibleMove.add(state[x + 2][y]);
        				casteling = true;
        			}
        		}
        	}
        	
        	r = state[0][0].getPiece();
        	if(r != null && r instanceof Rook){
        		if(r.getPlayerColor()==playerColor && !r.isHasMoved()){
        			if(!state[1][0].HasChild() && !state[2][0].HasChild() && !state[3][0].HasChild())
        			{
        				possibleMove.add(state[x - 2][y]);
        				casteling = true;
        			}
        		}
        	}
        	r = state[7][0].getPiece();
        	if(r != null && r instanceof Rook){
        		if(r.getPlayerColor()==playerColor && !r.isHasMoved()){
        			if(!state[5][0].HasChild() && !state[6][0].HasChild())
        			{
        				possibleMove.add(state[x + 2][y]);
        				casteling = true;
        			}
        		}
        	}
        }
        	
        return possibleMove;
    }


}
