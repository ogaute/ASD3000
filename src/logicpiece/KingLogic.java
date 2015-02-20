package logicpiece;

import gui.Square;
import guipiece.Piece;
import guipiece.Rook;

import java.util.ArrayList;
import java.util.Iterator;

import controller.Controller;

/**
 * Created by Anders Borg Larsen on 10.02.2015.
 */
public class KingLogic extends PieceLogic {
	
	boolean castelingBlackCanBeDone = true;
	boolean castelingWhiteCanBeDone = true;

    public ArrayList<Square> canIMove (Square[][] state, int x, int y, boolean c , ArrayList<Square> legaMovesWhenKingInCheck, boolean moving){
		ArrayList<Square> possibleMove = new ArrayList<Square>();
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
        
        //kingInCheckFilter(legaMovesWhenKingInCheck);
        if(moving){
        	possibleMove = kingInCheckFilter(state, possibleMove);
        }
        	
        return possibleMove;
    }

	private ArrayList<Square> kingInCheckFilter(Square[][] state, ArrayList<Square> possibleMove) {
		ArrayList<Square> copy = (ArrayList<Square>)possibleMove.clone();
		
		ArrayList<Square> kings = Controller.getKings();
		Square king = null;
		if(Controller.turn()){
			king = kings.get(0);
		}
		else {
			king = kings.get(1);
		}
		System.out.println("Konge trykket på: " + king.getPiece().toString());
		
		/*for (int i = 0; i < state.length; i++) {
			for (int k = 0; k < state[i].length; k++) {
				if(state[k][i].HasChild())
					System.out.println(state[k][i].getPiece().toString());
			}
		}
		System.out.println("--------------------------");*/
		
		Square[][] tryState = state.clone();
		Piece kingPiece = tryState[king.getIndexX()][king.getIndexY()].getPiece();
		tryState[king.getIndexX()][king.getIndexY()].removeAll();
		
		if(tryState[king.getIndexX()][king.getIndexY()].getPiece() != null){
			System.out.println("Konge er der enda");
		}
		else{
			System.out.println("Konge er ikke der");
		}
		
		for (Iterator iterator = copy.iterator(); iterator.hasNext();) {
			Square destination = (Square) iterator.next();
			
			ArrayList<PieceInControll> piecesInControll = Controller.isInControll(tryState, destination);
			
			for (Iterator iterator2 = piecesInControll.iterator(); iterator2.hasNext();) {
				PieceInControll pieceInControll = (PieceInControll) iterator2.next();
				System.out.println(pieceInControll.getPieceInControll().getPiece().toString());
			}
			
			if(!piecesInControll.isEmpty()){
				possibleMove.remove(destination);
			}
		}
		
		tryState[king.getIndexX()][king.getIndexY()].add(kingPiece);
		
		return possibleMove;
		
		/*for (int i = 0; i < state.length; i++) {
			for (int k = 0; k < state[i].length; k++) {
				if(state[k][i].HasChild())
					System.out.println(state[k][i].getPiece().toString());
			}
		}*/
		
	}


}
