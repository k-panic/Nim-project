package test;
import nim.GameState;
import nim.Move;

import org.junit.Assert;
import org.junit.Test;


public class GameStateTest  {
	
	@Test
	public void verifGameState()	{
		GameState n= new GameState(10);
		//verifie que le constructeur fait un tableau contenant les valeurs voulues
		boolean verifnbAl= true;
		for(int i=0 ; i<n.board.length;i++)	{
			if(n.board[i]!=2*i+1)	verifnbAl= false;
		}
		Move l= new Move(3,3);
		int t=n.board[l.ligne-1];int v=n.nbAl;
		n.supprimer(l);
		//verifie que la suppression est bien faite
		boolean res=(n.board.length>0 && n.board.length==10 && n.board[l.ligne-1]==t-l.allumettes && n.nbAl== v-l.allumettes && verifnbAl && v==10*10);
		
		Assert.assertEquals(true,res);
		
		
		
		
	}

}
